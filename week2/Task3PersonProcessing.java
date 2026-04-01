import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class PersonFilter {
    private static int ageLimit;

    public static void setAgeLimit(int value) {
        ageLimit = value;
    }

    public static boolean isOlderThanLimit(Person person) {
        return person.getAge() > ageLimit;
    }
}

public class Task3PersonProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = scanner.nextInt();

        String sortedNames = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .collect(Collectors.joining(" "));

        PersonFilter.setAgeLimit(ageLimit);
        String olderNames = persons.stream()
                .filter(PersonFilter::isOlderThanLimit)
                .map(Person::getName)
                .collect(Collectors.joining(" "));

        String upperCaseNames = persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        System.out.println(sortedNames);
        System.out.println(olderNames);
        System.out.println(upperCaseNames);
    }
}
