package com.mphasis.ui;

import java.io.IOException;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import com.mphasis.exception.DuplicateRegistrationException;
import com.mphasis.exception.ValidationException;
import com.mphasis.model.Property;
import com.mphasis.model.Vehicle;
import com.mphasis.model.VehicleType;
import com.mphasis.repository.InMemoryRepository;
import com.mphasis.service.StorageService;
import com.mphasis.service.TaxService;
import com.mphasis.util.FormatterUtil;

public class Menu {
	private final Scanner scanner = new Scanner(System.in);
    private final InMemoryRepository repo = new InMemoryRepository();
    private final TaxService taxService = new TaxService(repo);
    private final StorageService storageService = new StorageService();
    private final ConsoleIO io = new ConsoleIO();
    private final DecimalFormat df = FormatterUtil.getDecimalFormat();

    public void start() {
        showWelcome();
        mainLoop();
    }

    private void showWelcome() {
        System.out.println("============================================");
        System.out.println("        PROPERTY & VEHICLE TAX MANAGER      ");
        System.out.println("============================================");
        System.out.println("Developer: Parveen Banu Sulthan");
        System.out.println("Technology: Java (Maven project) - Console UI");
        System.out.println();
        System.out.println("Enter numeric choices to navigate menus.");
        System.out.println();
    }

    private void mainLoop() {
        while (true) {
            System.out.println("1. Add Property");
            System.out.println("2. Add Vehicle");
            System.out.println("3. Display Reports");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": handleAddProperty(); break;
                case "2": handleAddVehicle(); break;
                case "3": displayReports(); break;
                case "4":
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Enter 1-4.");
            }
        }
    }

    private void handleAddProperty() {
        try {
            System.out.println("--- Add Property ---");
            double baseValue = io.readDoublePositive("Base value of land (non-zero positive): ");
            double builtUpArea = io.readDoublePositive("Built-up area (positive): ");
            int age = io.readIntPositive("Age of construction (years, positive integer): ");
            char inCityChar = io.readYesNoChar("Is property in main city? (Y/N): ");

            boolean inCity = (inCityChar == 'Y');
            Property p = new Property(baseValue, builtUpArea, age, inCity);

            taxService.calculatePropertyTax(p);

            repo.addProperty(p);

            System.out.println("Computed property tax: INR " + df.format(p.getTax()));

            boolean save = io.readYesNo("Save to temporary CSV? (Y/N): ");
            if (save) {
                try { storageService.appendProperty(p); System.out.println("Saved to temp_properties.csv"); }
                catch (IOException e) { System.out.println("Failed to save: " + e.getMessage()); }
            }
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private void handleAddVehicle() {
        try {
            System.out.println("--- Add Vehicle ---");
            String reg = io.readRegistration("Registration (4 digits, leading zeros allowed, '0000' invalid): ");
            if (repo.isRegistrationPresent(reg)) throw new DuplicateRegistrationException("Registration already exists: " + reg);

            String brand = io.readNonEmptyString("Brand: ");
            double purchaseCost = io.readDoubleInRange("Purchase cost (50000 - 1000000): ", 50_000, 1_000_000);
            int velocity = io.readIntInRange("Max velocity (120 - 300): ", 120, 300);
            int capacity = io.readIntInRange("Capacity (2 - 50): ", 2, 50);

            System.out.println("Vehicle type: 1.Petrol 2.Diesel 3.CNG/LPG");
            int typeInt = io.readIntInRange("Choose type (1-3): ", 1, 3);
            VehicleType vtype = VehicleType.fromInt(typeInt);

            Vehicle v = new Vehicle(reg, brand, purchaseCost, velocity, capacity, vtype);

            taxService.calculateVehicleTax(v);

            repo.addVehicle(v);

            System.out.println("Computed vehicle tax: INR " + df.format(v.getTax()));

            boolean save = io.readYesNo("Save to temporary CSV? (Y/N): ");
            if (save) {
                try { storageService.appendVehicle(v); System.out.println("Saved to temp_vehicles.csv"); }
                catch (IOException e) { System.out.println("Failed to save: " + e.getMessage()); }
            }
        } catch (ValidationException | DuplicateRegistrationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayReports() {
        System.out.println("----- REPORTS -----");
        List<Property> props = repo.getAllProperties();
        List<Vehicle> vehs = repo.getAllVehicles();

        if (props.isEmpty() && vehs.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
            return;
        }

        if (!props.isEmpty()) {
            System.out.println("Properties:");
            System.out.printf("%-4s %-12s %-12s %-5s %-12s%n",
                    "No", "BaseValue", "BuiltUpArea", "Age", "Tax(INR)");
            int i=1;
            double sumProp = 0.0;
            for (Property p : props) {
                System.out.printf("%-4d %-12s %-12s %-5d %-12s%n",
                        i++,
                        df.format(p.getBaseValue()),
                        df.format(p.getBuiltUpArea()),
                        p.getAge(),
                        df.format(p.getTax()));
                sumProp += p.getTax();
            }
            System.out.println("Total properties: " + props.size());
            System.out.println("Sum of property taxes: INR " + df.format(sumProp));
        } else {
            System.out.println("No properties recorded.");
        }

        System.out.println();

        if (!vehs.isEmpty()) {
            System.out.println("Vehicles:");
            System.out.printf("%-4s %-8s %-12s %-6s %-6s %-12s%n",
                    "No","RegNo","Brand","Vel","Cap","Tax(INR)");
            int i=1;
            double sumVeh = 0.0;
            for (Vehicle v : vehs) {
                System.out.printf("%-4d %-8s %-12s %-6d %-6d %-12s%n",
                        i++,
                        v.getRegistrationNumber(),
                        v.getBrand(),
                        v.getVelocity(),
                        v.getCapacity(),
                        df.format(v.getTax()));
                sumVeh += v.getTax();
            }
            System.out.println("Total vehicles: " + vehs.size());
            System.out.println("Sum of vehicle taxes: INR " + df.format(sumVeh));
        } else {
            System.out.println("No vehicles recorded.");
        }

        double total = repo.getAllProperties().stream().mapToDouble(Property::getTax).sum()
                + repo.getAllVehicles().stream().mapToDouble(Vehicle::getTax).sum();
        System.out.println();
        System.out.println("Total tax payable (properties + vehicles): INR " + df.format(total));

        System.out.println("\nPress Enter to return to main menu...");
        scanner.nextLine();
}
}
