import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task10ThroneInheritance {
    static class ThroneInheritance {
        private final String king;
        private final Map<String, List<String>> children = new HashMap<>();
        private final Set<String> dead = new HashSet<>();

        public ThroneInheritance(String kingName) {
            this.king = kingName;
            children.put(kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
            children.putIfAbsent(childName, new ArrayList<>());
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> order = new ArrayList<>();
            dfs(king, order);
            return order;
        }

        private void dfs(String person, List<String> order) {
            if (!dead.contains(person)) {
                order.add(person);
            }

            List<String> list = children.get(person);
            if (list == null) {
                return;
            }

            for (String child : list) {
                dfs(child, order);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String king = scanner.next();
        int q = scanner.nextInt();
        ThroneInheritance throne = new ThroneInheritance(king);

        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            if (op.equals("birth")) {
                String parent = scanner.next();
                String child = scanner.next();
                throne.birth(parent, child);
            } else if (op.equals("death")) {
                String name = scanner.next();
                throne.death(name);
            } else if (op.equals("getInheritanceOrder")) {
                List<String> order = throne.getInheritanceOrder();
                System.out.println(String.join(" ", order));
            }
        }
    }
}
