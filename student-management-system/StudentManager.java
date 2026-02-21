import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Method (behaviour)
    // 1. Add new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("\nStudent added successfully");
    } 

    // 2. Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo student to display");
        } else {

            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                s.displayStudentInfo();
            }
        }
    }

    // 3. Update new student
    public void updateStudent(int id, String newName, int newAge, int newStandard) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            student.setStandard(newStandard);
            System.out.println("\nStudent updated successfully");
        } else {
            System.out.println("\nStudent not found");
        }
    }

    // Find student by their ID
    public Student searchStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            } 
        }
        return null;
    }

    // Remove student by their Id
    public void removeStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("\nStudent removed successfully");
                return;
            }
        }
        System.out.println("\nStudent not found");
    }
}