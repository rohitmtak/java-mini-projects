public class Student {
    // Private fields
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private int standard;

    // Constructor
    public Student(String name, int age, int standard) {
        if (standard < 1 || standard > 12) {
            throw new IllegalArgumentException("Standard should be between 1 to 12");
        }
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.age = age;
        this.standard = standard;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStandard() {
        return standard;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }


    public void setStandard(int newStandard) {
        if (newStandard < 1 || newStandard > 12) {
            throw new IllegalArgumentException("Standard should be between 1 and 12");
        }
        this.standard = newStandard;
    }

    // Display Student Info
    public void displayStudentInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Standard: " + standard);
    }
    
}
