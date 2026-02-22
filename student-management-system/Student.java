// Student class to represent student's information 
// Data class - only contains data, no behavior

class Student {
    private final int id;
    private String name;
    private int age;
    private int standard;

    // Constructor
    public Student(int id, String name, int age, int standard) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 5 || age > 18) {
            throw new IllegalArgumentException("Age must be between 5 and 18");
        }
        if (standard < 1 || standard > 12) {
            throw new IllegalArgumentException("Standard must be between 1 and 12");
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.standard = standard;
    }


    // Getters (accessors)
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

    // Setters (mutators)
    // Set new name
    public void setName(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = newName;
    }

    // Set new age
    public void setAge(int newAge) {
        if (newAge < 5 || newAge > 18) {
            throw new IllegalArgumentException("Age must be between 5 and 18");
        }
        this.age = newAge;
    }

    // Set new standard
    public void setStandard(int newStandard) {
        if (newStandard < 1 || newStandard > 12) {
            throw new IllegalArgumentException("Standard must be between 1 and 12");
        }
        this.standard = newStandard;
    }

    // Display student info
    // Override the toString method to return the student info
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Standard: " + standard;
    }
}