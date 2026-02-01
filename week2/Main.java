import java.util.*;
import java.util.stream.*;

public class Main {

   
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }
    }

    
    static boolean isOlderThanLimit(Person p, int limit) {
        return p.getAge() > limit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        List<Person> sortedList = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        sortedList.forEach(p -> System.out.print(p.getName() + " "));
        System.out.println();

        persons.stream()
                .filter(p -> isOlderThanLimit(p, ageLimit))
                .forEach(p -> System.out.print(p.getName() + " "));
        System.out.println();

        persons.stream()
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));
    }
}