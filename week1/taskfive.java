import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

public class taskfive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");
            String name = parts[0];
            int marks = Integer.parseInt(parts[1]);
            students.add(new Student(name, marks));
        }

        int k = sc.nextInt();

        // Sort: descending marks, then alphabetical name
        List<String> topK = students.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed()
                        .thenComparing(Student::getName))
                .limit(k)
                .map(Student::getName)
                .collect(Collectors.toList());

        // Print top K names
        System.out.println(String.join(" ", topK));
    }
}
