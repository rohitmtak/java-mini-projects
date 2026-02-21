## Concepts Learned

### 1. ArrayList (Collections)
- `ArrayList<Student>` is a growable list — unlike arrays, it can expand and shrink
- Import: `import java.util.ArrayList;`
- Key methods:
  | Method | What it does |
  |---|---|
  | `.add(item)` | Adds item to end of list |
  | `.get(i)` | Gets item at index i |
  | `.remove(i)` | Removes item at index i |
  | `.size()` | Returns number of items |
  | `.isEmpty()` | Returns true if list is empty |

### 2. Static Variables
- `private static int idCounter = 1;` — shared across ALL Student objects
- Regular field = each object gets its own copy
- Static field = one copy shared by the entire class
- Used here for auto-incrementing student IDs

### 3. Separation of Concerns
- Split responsibilities across classes instead of putting everything in one file
  | Class | Role |
  |---|---|
  | `Student.java` | Data — holds one student's info |
  | `StudentManager.java` | Logic — manages the list (add, remove, search, update) |
  | `StudentManagement.java` | UI — menu, Scanner, user interaction |
- Manager doesn't know about Scanner. Main class doesn't manage the list directly.

### 4. Looping Through Objects
- Pattern used in search, display, and remove:

```java
for (int i = 0; i < students.size(); i++) {
    Student s = students.get(i);
    // do something with s
}
```

- Search: loop + return when found, return null after loop
- Remove: loop + remove + return when found, print "not found" AFTER the loop

### 5. Menu-Driven Program
- `while (true)` keeps the program running until user picks Exit
- `break` exits the loop
- `Scanner` reads user input (`nextInt()`, `next()`)

### 6. Setters
- Allow updating a field after the object is created
- Pattern: `public void setName(String newName) { this.name = newName; }`
- No setter for `id` — once assigned, it shouldn't change (encapsulation)

### 7. Throwing Exceptions
- `throw new IllegalArgumentException("message")` — stops execution with an error
- More professional than just printing an error message
- Used in constructor and setter for standard validation (must be 1-12)

### 8. "Not Found" Logic in Loops
- Print "not found" AFTER the loop, not inside an else on each iteration
- Inside the loop: only check for matches, use `return` to exit early when found
- If the loop finishes without returning, the item wasn't found

## Lessons Learned from this Project
- Constructor parameter name didn't match class name
- Validation condition was inverted (checking valid range instead of invalid)
- "Student not found" printed inside the loop instead of after it
- `removeStudent` had else + return that stopped after checking only the first student
- Duplicate print messages (both in manager method and in main)
- `choice` numbers didn't match menu options
- Passing wrong arguments to constructor (id for age, name for email)
- Unused imports left in the file

## How to Run
```bash
cd student-management-system
javac Student.java StudentManager.java StudentManagement.java
java StudentManagement
