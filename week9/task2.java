import java.util.*;

// Base class
class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int vehicleId, String modelName, double baseRent) {
        this.vehicleId = vehicleId;
        this.modelName = modelName;
        this.baseRent = baseRent;
    }

    // Method to calculate rent (overridden in subclasses)
    double calculateRent() {
        return baseRent;
    }

    // Display method
    void display() {
        System.out.println("Vehicle ID: " + vehicleId +
                ", Model: " + modelName +
                ", Total Rent: " + calculateRent());
    }
}

// Car subclass
class Car extends Vehicle {
    int seats;

    Car(int vehicleId, String modelName, double baseRent, int seats) {
        super(vehicleId, modelName, baseRent);
        this.seats = seats;
    }

    @Override
    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

// Bike subclass
class Bike extends Vehicle {
    int engineCapacity;

    Bike(int vehicleId, String modelName, double baseRent, int engineCapacity) {
        super(vehicleId, modelName, baseRent);
        this.engineCapacity = engineCapacity;
    }

    @Override
    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of vehicles
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);

            if (type == 'C') {
                int id = sc.nextInt();
                String model = sc.next();
                double baseRent = sc.nextDouble();
                int seats = sc.nextInt();

                vehicles.add(new Car(id, model, baseRent, seats));

            } else if (type == 'B') {
                int id = sc.nextInt();
                String model = sc.next();
                double baseRent = sc.nextDouble();
                int engineCapacity = sc.nextInt();

                vehicles.add(new Bike(id, model, baseRent, engineCapacity));
            }
        }

        // Display all vehicles
        for (Vehicle v : vehicles) {
            v.display();
        }

        sc.close();
    }
}
