import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class PersonHeight {
    String name;
    int height;

    PersonHeight(String name, int height) {
        this.name = name;
        this.height = height;
    }
}

public class Task6SortThePeople {
    public static String[] sortPeople(String[] names, int[] heights) {
        List<PersonHeight> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new PersonHeight(names[i], heights[i]));
        }

        list.sort(Comparator.comparingInt((PersonHeight p) -> p.height).reversed());

        String[] result = new String[names.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).name;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        String[] names = new String[n];
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        String output = String.join(" ", sortPeople(names, heights));
        System.out.println(output);

        List<String> sorted = new ArrayList<>();
        sorted.add(output);
        sorted.stream().map(String::toString).collect(Collectors.toList());
    }
}
