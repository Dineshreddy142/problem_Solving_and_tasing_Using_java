import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Event {
    private final String name;
    private final LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}

public class Task4EventProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            LocalDate date = LocalDate.parse(scanner.next());
            events.add(new Event(name, date));
        }

        int month = scanner.nextInt();

        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());

        String sortedNames = sortedEvents.stream()
                .map(Event::getName)
                .collect(Collectors.joining(" "));

        String earliest = sortedEvents.isEmpty() ? "" : sortedEvents.get(0).getName();
        String latest = sortedEvents.isEmpty() ? "" : sortedEvents.get(sortedEvents.size() - 1).getName();

        int latestYear = sortedEvents.isEmpty() ? 0 : sortedEvents.get(sortedEvents.size() - 1).getDate().getYear();

        String monthEvents = sortedEvents.stream()
            .filter(e -> e.getDate().getMonthValue() == month && e.getDate().getYear() == latestYear)
                .map(Event::getName)
                .collect(Collectors.joining(" "));

        System.out.println(sortedNames);
        System.out.println(earliest);
        System.out.println(latest);
        System.out.println(monthEvents);
    }
}
