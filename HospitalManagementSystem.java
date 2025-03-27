import java.util.ArrayList;
import java.util.Scanner;

// Main Class
public class HospitalManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Staff> staff = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<String> inventory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System");
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Electronic Health Records");
            System.out.println("4. Billing and Invoicing");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> patientRegistration();
                case 2 -> appointmentScheduling();
                case 3 -> electronicHealthRecords();
                case 4 -> billingAndInvoicing();
                case 5 -> inventoryManagement();
                case 6 -> staffManagement();
                case 7 -> {
                    System.out.println("Thank you for using the Hospital Management System!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Patient Registration
    public static void patientRegistration() {
        System.out.println("\n--- Patient Registration ---");
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.next();

        patients.add(new Patient(name, age, contact));
        System.out.println("Patient registered successfully!");
    }

    // Appointment Scheduling
    public static void appointmentScheduling() {
        System.out.println("\n--- Appointment Scheduling ---");
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.next();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.next();
        System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
        String date = scanner.next();

        appointments.add(new Appointment(patientName, doctorName, date));
        System.out.println("Appointment scheduled successfully!");
    }

    // Electronic Health Records
    public static void electronicHealthRecords() {
        System.out.println("\n--- Electronic Health Records ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    // Billing and Invoicing
    public static void billingAndInvoicing() {
        System.out.println("\n--- Billing and Invoicing ---");
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.next();
        System.out.print("Enter Treatment Cost: ");
        double cost = scanner.nextDouble();
        System.out.println("Invoice Generated:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Total Cost: $" + cost);
    }

    // Inventory Management
    public static void inventoryManagement() {
        System.out.println("\n--- Inventory Management ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Medical Supplies");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        if (option == 1) {
            if (inventory.isEmpty()) {
                System.out.println("Inventory is empty.");
            } else {
                System.out.println("Medical Supplies in Inventory:");
                for (String item : inventory) {
                    System.out.println(item);
                }
            }
        } else if (option == 2) {
            System.out.print("Enter Item Name: ");
            String item = scanner.next();
            inventory.add(item);
            System.out.println("Item added to inventory.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    // Staff Management
    public static void staffManagement() {
        System.out.println("\n--- Staff Management ---");
        System.out.println("1. View Staff");
        System.out.println("2. Add Staff");
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        if (option == 1) {
            if (staff.isEmpty()) {
                System.out.println("No staff added yet.");
            } else {
                for (Staff member : staff) {
                    System.out.println(member);
                }
            }
        } else if (option == 2) {
            System.out.print("Enter Staff Name: ");
            String name = scanner.next();
            System.out.print("Enter Role: ");
            String role = scanner.next();
            staff.add(new Staff(name, role));
            System.out.println("Staff added successfully!");
        } else {
            System.out.println("Invalid option.");
        }
    }
}

// Supporting Classes
class Patient {
    String name;
    int age;
    String contact;

    Patient(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name + ", Age: " + age + ", Contact: " + contact;
    }
}

class Appointment {
    String patientName;
    String doctorName;
    String date;

    Appointment(String patientName, String doctorName, String date) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment for " + patientName + " with Dr. " + doctorName + " on " + date;
    }
}

class Staff {
    String name;
    String role;

    Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff Name: " + name + ", Role: " + role;
    }
}