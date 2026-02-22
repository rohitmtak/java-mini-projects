import java.util.Scanner;

// StudentManagement class to show the menu, read user input, and call StudentManager methods - this is the main class that runs the program
// UI class - only contains UI and user interaction

public class StudentManagement {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. View All Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit Program");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt(); 
            scanner.nextLine();  // to clear the buffer

            // Main menu 
            switch (choice) {
                case 1:
                    viewAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Add student
    private static void addStudent() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim(); // to remove leading and trailing spaces
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            return;
        }

        System.out.print("Age: ");
        int age = scanner.nextInt(); 
        scanner.nextLine();
        if (age < 5 || age > 18) {
            System.out.println("Error: Age must be between 5 and 18");
            return;
        }

        System.out.print("Standard: ");
        int standard = scanner.nextInt();
        scanner.nextLine();
        if (standard < 1 || standard > 12) {
            System.out.println("Error: Standard must be between 1 and 12");
            return;
        }

        manager.addStudent(name, age, standard);
        System.out.println("Student added.");
    }

    // View all students
    private static void viewAllStudents() {
        manager.viewAllStudents();
    }

    // Update student
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            return;
        }

        System.out.print("New age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age < 5 || age > 18) {
            System.out.println("Error: Age must be between 5 and 18");
            return;
        }

        System.out.print("New standard: ");
        int standard = scanner.nextInt();
        scanner.nextLine();
        if (standard < 1 || standard > 12) {
            System.out.println("Error: Standard must be between 1 and 12");
            return;
        }
        // Try to update student
        // If the student is found, update the student and print the success message
        try {
            if (manager.updateStudent(id, name, age, standard)) {
                System.out.println("Updated.");
            } else {
                System.out.println("Student not found.");
            }
        // If the student is not found, print the error message
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search student
    private static void searchStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = manager.searchStudent(id);
        System.out.println(s != null ? s : "Student not found.");  
    }

    // Remove student
    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (manager.removeStudent(id)) {
            System.out.println("Removed.");
        } else {
            System.out.println("Student not found.");
        }
    }
}