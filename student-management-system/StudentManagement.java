import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Main loop
        while (true) {
            System.out.println("\n--- Student Mangement System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit Program");
            System.out.println("\nChoose an option: ");

            int choice = scanner.nextInt();

            // 1. Add student
            if (choice == 1) {
                System.out.println("\nEnter student name: ");
                String name = scanner.next();
                System.out.println("Enter student age: ");
                int age = scanner.nextInt();
                System.out.println("Enter student standard: ");
                int standard = scanner.nextInt();
                Student student = new Student(name, age, standard); 
                manager.addStudent(student);
            } 

            // 2. Display students
            else if (choice == 2) {
                manager.displayAllStudents();
            } 

            // 3. Update student
            else if (choice == 3) {
                System.out.println("\nEnter student ID: ");
                int id = scanner.nextInt();
                System.out.println("Enter new name: ");
                String name = scanner.next();
                System.out.println("Enter new age: ");
                int age = scanner.nextInt();
                System.out.println("Enter new standard: ");
                int standard = scanner.nextInt();
                manager.updateStudent(id, name, age, standard);
            }
            
            // 4. Search student
            else if (choice == 4) {
                System.out.println("\nEnter student ID: ");
                int id = scanner.nextInt();
                Student student = manager.searchStudent(id);
                if (student != null) {
                    student.displayStudentInfo();
                } else {
                    System.out.println("Student not found");
                }

            }

            // 5. Remove student
            else if (choice == 5) {
                System.out.println("\nEnter student ID: ");
                int id = scanner.nextInt();
                manager.removeStudent(id);
            }

            // 6. Exit the program
            else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            }

            // Invalid choice
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}       
    
