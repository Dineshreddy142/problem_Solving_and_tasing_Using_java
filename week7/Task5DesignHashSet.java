import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task5DesignHashSet {
    static class MyHashSet {
        private static final int SIZE = 1009;
        private final List<Integer>[] buckets;

        @SuppressWarnings("unchecked")
        public MyHashSet() {
            buckets = new List[SIZE];
            for (int i = 0; i < SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hash(int key) {
            return key % SIZE;
        }

        public void add(int key) {
            int idx = hash(key);
            if (!buckets[idx].contains(key)) {
                buckets[idx].add(key);
            }
        }

        public void remove(int key) {
            int idx = hash(key);
            buckets[idx].remove(Integer.valueOf(key));
        }

        public boolean contains(int key) {
            return buckets[hash(key)].contains(key);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int q = scanner.nextInt();
        MyHashSet set = new MyHashSet();

        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            int key = scanner.nextInt();

            if (op.equals("add")) {
                set.add(key);
            } else if (op.equals("remove")) {
                set.remove(key);
            } else if (op.equals("contains")) {
                System.out.println(set.contains(key));
            }
        }
    }
}
