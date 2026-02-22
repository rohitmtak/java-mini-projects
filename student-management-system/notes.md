## OOP in this project

| OOP Concept | How we use it in this project |
|-------------|------------------------------|
| **Classes & Objects** | `Student` is a class; each student we add is an *object* (instance). `StudentManager` is another class; we create one instance in `StudentManagement` and call its methods. |
| **Encapsulation** | We keep fields `private` (e.g. `id`, `name`, `age`, `standard` in `Student`). Other code cannot access them directly; they use **getters** to read and **setters** to change values (with validation). |
| **Abstraction** | The UI (`StudentManagement`) doesn’t know how the list is stored or how IDs are assigned. It only calls methods like `addStudent()`, `searchStudent()`. The inner details are hidden. |
| **Single Responsibility** | Each class has one job: `Student` = hold data, `StudentManager` = manage the list, `StudentManagement` = menu and user input. This is also called *separation of concerns*. |
| **No setter for `id`** | We expose only what should change. `id` is set once in the constructor (by the manager) and never changed — so we don’t provide `setId()`. |

We do **not** use inheritance or polymorphism in this small project; the focus is on encapsulation, classes/objects, and separation of concerns.


## In depth

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
- In this project we use: `.add()`, `.isEmpty()`, and `.remove(student)` (by object). We do **not** use `.get(i)` or `.size()` because we iterate with the enhanced for-loop (see §4).


### 2. Use of nextId
- `nextId` is an **instance field** in `StudentManager` (not in `Student`): `private int nextId = 1;`
- It is the counter used to assign a **unique ID** to each new student when we add one
- When adding a student we do: `students.add(new Student(nextId++, name, age, standard));`
  - `nextId++` means: use the current value of `nextId` for this student, then add 1 to `nextId` for the next time
  - First student gets ID 1, second gets 2, and so on
- Keeping ID assignment in `StudentManager` (and not in `Student`) keeps the `Student` class simple: it only holds data and validates it; the manager decides the ID


### 3. Separation of Concerns
- Split responsibilities across classes instead of putting everything in one file
  | Class | Role |
  |---|---|
  | `Student.java` | Data — holds one student's info |
  | `StudentManager.java` | Logic — manages the list (add, remove, search, update) |
  | `StudentManagement.java` | UI — menu, Scanner, user interaction |
- Manager doesn't know about Scanner. Main class doesn't manage the list directly.


### 4. Looping Through the Student List

We use the **enhanced for-loop** to go through `students`: `for (Student student : students) { ... }` — “for each student in the list, do something.”

| Where | In the loop we… | If no match / empty list |
|-------|------------------|---------------------------|
| **viewAllStudents()** | Print each: `System.out.println(student)` | Print “No students found” (we check `isEmpty()` first) |
| **searchStudent(id)** | If `student.getId() == id`, return that student | Return `null`; UI prints “Student not found.” |
| **removeStudent(id)** | If `student.getId() == id`, remove it and return `true` | Return `false`; UI prints “Student not found.” |

“Not found” is always handled *after* the loop (or in the UI), never inside the loop on every iteration.


### 5. Menu-Driven Program
- `while (running)` keeps the program running until user picks Exit (option 6 sets `running = false`)
- `break` exits the switch after each case so we don’t fall through to the next option
- `Scanner` reads user input: `nextInt()` for numbers, `nextLine()` for text
- **Important:** After `nextInt()` we call `scanner.nextLine()` to clear the newline left in the buffer; otherwise the next `nextLine()` may read an empty line


### 6. Role of Getters and Setters

- **Getters** — Return the value of a private field (`getId()`, `getName()`). Let other classes *read* the data; without getters, `private` fields can’t be accessed from outside.
- **Setters** — Assign a new value to a private field (`setName()`, `setAge()`). Let other classes *change* data in a controlled way: we validate inside (e.g. age 5–18) and throw if invalid.
- **Why both?** Encapsulation: hide fields, expose only what we want. We can validate, change internals later, or omit a setter (e.g. no `setId()` — ID never changes after creation).


### 7. Throwing Exceptions
- `throw new IllegalArgumentException("message")` — stops execution with an error
- More professional than just printing an error message
- Used in constructor and setters for validation: name (non-empty), age (5–18), standard (1–12)


### 8. "Not Found" Logic in Loops
- Print "not found" AFTER the loop, not inside an else on each iteration
- Inside the loop: only check for matches, use `return` to exit early when found
- If the loop finishes without returning, the item wasn't found


### 9. Override (@Override)

- **What:** Every class has `toString()` from `Object` (default: `Student@1a2b3c`). We write our own `toString()` in `Student` — that’s **overriding**: our version is used instead.
- **Why:** So `System.out.println(student)` prints something readable (ID, name, age, standard) instead of the default.
- **@Override:** Put it above the method so the compiler checks we really are overriding; it errors if we misspell the method or change the signature.


## Lessons Learned from this Project

Mistakes made (and fixed) while building this project:

- Constructor parameter name didn't match the field/class (e.g. confusing parameter names)
- Validation condition was inverted (was checking valid range instead of invalid)
- "Student not found" printed inside the loop instead of after it
- `removeStudent` had `else` + `return` that stopped after checking only the first student
- Duplicate print messages (both in manager and in main)
- Passing wrong arguments to constructor (e.g. id for age, name for email)
- Unused imports left in the file

New one to watch for future projects:

- Not handling invalid input: if the user types non-numeric text where a number is expected (choice, age, ID, standard), `scanner.nextInt()` throws `InputMismatchException` and the program crashes. Fix: use try-catch or `hasNextInt()` and re-prompt.


## How to Run
```bash
cd student-management-system
javac Student.java StudentManager.java StudentManagement.java
java StudentManagement
