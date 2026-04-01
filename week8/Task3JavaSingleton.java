import java.util.Scanner;

public class Task3JavaSingleton {
    static class Singleton {
        public String str;
        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getSingleInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.hasNextLine() ? scanner.nextLine() : "";

        Singleton singleton = Singleton.getSingleInstance();
        singleton.str = s;

        System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
    }
}
