import java.util.*;

class EntityRecord {
    int enrollmentId;
    String student;
    String course;
    String instructor;
    String startDate;
    int duration;

    // Constructor
    EntityRecord(int enrollmentId, String student, String course,
                 String instructor, String startDate, int duration) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.instructor = instructor;
        this.startDate = startDate;
        this.duration = duration;
    }

    // Method to display record
    void display() {
        System.out.println("Enrollment_ID: " + enrollmentId +
                ", Student: " + student +
                ", Course: " + course +
                ", Instructor: " + instructor +
                ", Start Date: " + startDate +
                ", Duration: " + duration + " weeks");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of records
        List<EntityRecord> records = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String student = sc.next();
            String course = sc.next();
            String instructor = sc.next();
            String startDate = sc.next();
            int duration = sc.nextInt();

            records.add(new EntityRecord(id, student, course, instructor, startDate, duration));
        }

        // Display all records
        for (EntityRecord record : records) {
            record.display();
        }

        sc.close();
    }
}
