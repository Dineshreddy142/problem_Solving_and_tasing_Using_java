import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4JavaVisitorPattern {
    enum Color {
        RED,
        GREEN
    }

    abstract static class Tree {
        private final int value;
        private final Color color;
        private final int depth;

        Tree(int value, Color color, int depth) {
            this.value = value;
            this.color = color;
            this.depth = depth;
        }

        int getValue() {
            return value;
        }

        Color getColor() {
            return color;
        }

        int getDepth() {
            return depth;
        }

        abstract void accept(TreeVis visitor);
    }

    static class TreeNode extends Tree {
        private final List<Tree> children = new ArrayList<>();

        TreeNode(int value, Color color, int depth) {
            super(value, color, depth);
        }

        void addChild(Tree child) {
            children.add(child);
        }

        @Override
        void accept(TreeVis visitor) {
            visitor.visitNode(this);
            for (Tree child : children) {
                child.accept(visitor);
            }
        }
    }

    static class TreeLeaf extends Tree {
        TreeLeaf(int value, Color color, int depth) {
            super(value, color, depth);
        }

        @Override
        void accept(TreeVis visitor) {
            visitor.visitLeaf(this);
        }
    }

    abstract static class TreeVis {
        abstract int getResult();

        abstract void visitNode(TreeNode node);

        abstract void visitLeaf(TreeLeaf leaf);
    }

    static class SumInLeavesVisitor extends TreeVis {
        private int sum = 0;

        @Override
        int getResult() {
            return sum;
        }

        @Override
        void visitNode(TreeNode node) {
        }

        @Override
        void visitLeaf(TreeLeaf leaf) {
            sum += leaf.getValue();
        }
    }

    static class ProductOfRedNodesVisitor extends TreeVis {
        private static final int MOD = 1000000007;
        private long product = 1;

        @Override
        int getResult() {
            return (int) product;
        }

        @Override
        void visitNode(TreeNode node) {
            if (node.getColor() == Color.RED) {
                product = (product * node.getValue()) % MOD;
            }
        }

        @Override
        void visitLeaf(TreeLeaf leaf) {
            if (leaf.getColor() == Color.RED) {
                product = (product * leaf.getValue()) % MOD;
            }
        }
    }

    static class FancyVisitor extends TreeVis {
        private int nonLeafEvenDepthSum = 0;
        private int greenLeafSum = 0;

        @Override
        int getResult() {
            return Math.abs(nonLeafEvenDepthSum - greenLeafSum);
        }

        @Override
        void visitNode(TreeNode node) {
            if (node.getDepth() % 2 == 0) {
                nonLeafEvenDepthSum += node.getValue();
            }
        }

        @Override
        void visitLeaf(TreeLeaf leaf) {
            if (leaf.getColor() == Color.GREEN) {
                greenLeafSum += leaf.getValue();
            }
        }
    }

    private static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }

        Color[] colors = new Color[n + 1];
        for (int i = 1; i <= n; i++) {
            colors[i] = scanner.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        return buildTree(1, 0, 0, values, colors, graph);
    }

    private static Tree buildTree(int node, int parent, int depth, int[] values, Color[] colors, List<Integer>[] graph) {
        boolean isLeaf = parent != 0 && graph[node].size() == 1;
        if (isLeaf) {
            return new TreeLeaf(values[node], colors[node], depth);
        }

        TreeNode treeNode = new TreeNode(values[node], colors[node], depth);
        for (int next : graph[node]) {
            if (next != parent) {
                treeNode.addChild(buildTree(next, node, depth + 1, values, colors, graph));
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        Tree root = solve();

        TreeVis vis1 = new SumInLeavesVisitor();
        TreeVis vis2 = new ProductOfRedNodesVisitor();
        TreeVis vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }
}
