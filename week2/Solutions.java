import java.util.*;
import java.time.*;
import java.time.format.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, String dateStr) {
        this.name = name;
        this.date = LocalDate.parse(dateStr); // Parse yyyy-MM-dd
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}

public class Solutions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+"); // name and date
            events.add(new Event(parts[0], parts[1]));
        }

        int month = sc.nextInt(); // month to filter

     
        events.sort(Comparator.comparing(Event::getDate));

        // Print sorted names
        events.forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();

     
        System.out.println(events.get(0).getName());


        System.out.println(events.get(events.size() - 1).getName());

   
        events.stream()
                .filter(e -> e.getDate().getMonthValue() == month)
                .forEach(e -> System.out.print(e.getName() + " "));
    }
}
