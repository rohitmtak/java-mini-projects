import java.util.ArrayList;

// StudentManager class to manage the list of students
// Logic class - only contains logic

class StudentManager {
    private ArrayList<Student> students; // list of students
    private int nextId = 1;  // simple counter to assign the next id when adding a student

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add student (assign the id here, so Student class stays simple)
    public void addStudent(String name, int age, int standard) {
        students.add(new Student(nextId++, name, age, standard));
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Update student
    public boolean updateStudent(int id, String newName, int newAge, int newStandard) {
        Student student = searchStudent(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            student.setStandard(newStandard);
            return true;
        }
        return false;
    }

    // Search student
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student; 
            }
        }
        return null; 
    }

    // Remove student
    public boolean removeStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }
}