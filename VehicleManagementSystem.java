import java.util.Scanner;
import java.time.Year;

class Vehicle {
    String brand, model;
    int year;
    double basePrice;

    Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    double calculateResaleValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        return basePrice * Math.pow(0.85, age);
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: ₹" + basePrice);
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String brand, String model, int year, double basePrice, int doors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = doors;
    }

    double calculateInsurance() {
        return 5000 + 1000 * numberOfDoors;
    }

    double calculateMaintenance() {
        return 3000 + 500 * numberOfDoors;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance: ₹" + calculateInsurance());
        System.out.println("Maintenance: ₹" + calculateMaintenance());
        System.out.printf("Resale Value: ₹%.2f\n", calculateResaleValue());
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    double calculateInsurance() {
        return 2500 + (hasSidecar ? 1500 : 0);
    }

    double calculateMaintenance() {
        return 2000 + (hasSidecar ? 1000 : 0);
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance: ₹" + calculateInsurance());
        System.out.println("Maintenance: ₹" + calculateMaintenance());
        System.out.printf("Resale Value: ₹%.2f\n", calculateResaleValue());
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Car Input
        System.out.println("Enter Car details:");
        System.out.print("Brand: ");
        String cBrand = sc.nextLine();
        System.out.print("Model: ");
        String cModel = sc.nextLine();
        System.out.print("Year: ");
        int cYear = sc.nextInt();
        System.out.print("Base Price: ");
        double cPrice = sc.nextDouble();
        System.out.print("Number of Doors: ");
        int doors = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        Car car = new Car(cBrand, cModel, cYear, cPrice, doors);

        // Motorcycle Input
        System.out.println("\nEnter Motorcycle details:");
        System.out.print("Brand: ");
        String mBrand = sc.nextLine();
        System.out.print("Model: ");
        String mModel = sc.nextLine();
        System.out.print("Year: ");
        int mYear = sc.nextInt();
        System.out.print("Base Price: ");
        double mPrice = sc.nextDouble();
        System.out.print("Has Sidecar? (true/false): ");
        boolean sidecar = sc.nextBoolean();

        Motorcycle bike = new Motorcycle(mBrand, mModel, mYear, mPrice, sidecar);

        // Display both
        System.out.println("\n--- Car Info ---");
        car.displayInfo();

        System.out.println("\n--- Motorcycle Info ---");
        bike.displayInfo();

        sc.close();
    }

}
