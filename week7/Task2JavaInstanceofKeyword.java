import java.util.ArrayList;
import java.util.Scanner;

public class Task2JavaInstanceofKeyword {
    static class Student {
    }

    static class Rockstar {
    }

    static class Hacker {
    }

    public static String count(ArrayList<Object> myList) {
        int a = 0;
        int b = 0;
        int c = 0;

        for (Object element : myList) {
            if (element instanceof Student) {
                a++;
            }
            if (element instanceof Rockstar) {
                b++;
            }
            if (element instanceof Hacker) {
                c++;
            }
        }

        return a + " " + b + " " + c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Object> myList = new ArrayList<>();

        while (t-- > 0) {
            String s = sc.next();
            if (s.equals("Student")) {
                myList.add(new Student());
            }
            if (s.equals("Rockstar")) {
                myList.add(new Rockstar());
            }
            if (s.equals("Hacker")) {
                myList.add(new Hacker());
            }
        }

        System.out.println(count(myList));
    }
}
