import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4DesignBrowserHistory {
    static class BrowserHistory {
        private final List<String> history = new ArrayList<>();
        private int index = 0;

        public BrowserHistory(String homepage) {
            history.add(homepage);
        }

        public void visit(String url) {
            while (history.size() > index + 1) {
                history.remove(history.size() - 1);
            }
            history.add(url);
            index++;
        }

        public String back(int steps) {
            index = Math.max(0, index - steps);
            return history.get(index);
        }

        public String forward(int steps) {
            index = Math.min(history.size() - 1, index + steps);
            return history.get(index);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            return;
        }

        String homepage = scanner.next();
        int q = scanner.nextInt();
        BrowserHistory browser = new BrowserHistory(homepage);

        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            if (op.equals("visit")) {
                String url = scanner.next();
                browser.visit(url);
            } else if (op.equals("back")) {
                int steps = scanner.nextInt();
                System.out.println(browser.back(steps));
            } else if (op.equals("forward")) {
                int steps = scanner.nextInt();
                System.out.println(browser.forward(steps));
            }
        }
    }
}
