## OOP in this project

| OOP Concept | How we use it in this project |
|-------------|------------------------------|
| **Classes & Objects** | `BankAccount` is a class; each account we create (e.g. `account1`) is an *object* (instance). `BankAccountDemo` is another class with a `main` method that creates and uses `BankAccount` objects. |
| **Encapsulation** | We keep fields `private` (e.g. `accountNumber`, `accountHolderName`, `balance`). Other code cannot access them directly; they use **getBalance()** to read balance and **deposit()** / **withdraw()** to change it (with validation). You cannot do `account1.balance = 5000` — that would give an error. |
| **Abstraction** | The demo doesn’t need to know how balance is stored or how validation works. It only calls `deposit()`, `withdraw()`, `getBalance()`, `displayAccountInfo()`. The inner details are hidden. |
| **Single Responsibility** | Each class has one job: `BankAccount` = hold account data and provide safe operations (deposit, withdraw, display); `BankAccountDemo` = run a demo (create account, perform transactions, print results). |

We do **not** use inheritance or polymorphism in this small project; the focus is on encapsulation, classes/objects, and validation through methods.


## In depth

### 1. Classes and Objects
- A **class** is a blueprint (`BankAccount.java`)
- An **object** is an instance created from that blueprint
- `BankAccount account1 = new BankAccount("213433", "Rohit", 1000);` creates an object


### 2. Access Modifiers
- `private` — only accessible inside the class (fields: `accountNumber`, `accountHolderName`, `balance`)
- `public` — accessible from anywhere (constructor, methods: `deposit`, `withdraw`, `getBalance`, `displayAccountInfo`)
- Think of it like an ATM: cash inside is private, buttons are public


### 3. Constructor and `this`
- **Constructor** — Special method that runs when you create an object with `new`. Same name as the class, no return type. Used to initialize fields.
- **`this`** — Refers to the current object. `this.balance = balance` means: set the object’s balance to the parameter’s value. Used when parameter names match field names to avoid confusion.


### 4. Encapsulation: No Setter for Balance
- We expose only what should change. Balance is not set directly; it changes only through **deposit()** and **withdraw()**, so we don’t provide `setBalance()`. This prevents invalid states (e.g. negative balance by direct assignment).
- **getBalance()** lets other code *read* the balance; they cannot modify it except through the allowed methods.


### 5. Return vs Print (void vs return value)
- **void** methods do something but return nothing (`deposit`, `withdraw`, `displayAccountInfo`). They may print messages inside.
- **double getBalance()** returns a value — the caller decides what to do with it (e.g. `System.out.println(account1.getBalance())`).
- Prefer returning values when the caller might need to use the result; use void when the method’s job is to perform an action or print.


### 6. Validation
- Always validate inputs before modifying data: negative amounts, zero, insufficient balance, negative initial balance.
- In **constructor**: if `balance < 0`, we don’t set it (or we could throw an exception for a stricter design).
- In **deposit()**: only add if `amount >= 0`.
- In **withdraw()**: check `amount <= 0` first, then `amount <= balance`. Order of checks matters.


### 7. Compilation Flow

```
You write        →  javac compiles  →  java runs
─────────           ──────────────     ─────────
.java files    →    .class files   →   output in terminal
(human code)        (bytecode)         (results)
```

- Every `.java` file gets its own `.class` file (one-to-one mapping)

| Source File         | Compiled File         |
|---------------------|------------------------|
| `BankAccount.java`  | `BankAccount.class`    |
| `BankAccountDemo.java` | `BankAccountDemo.class` |

- Changed a `.java` file? Recompile with `javac` before running with `java`.
- Compile both files together: `javac BankAccount.java BankAccountDemo.java` (or `javac *.java`).


### 8. Possible Improvement: Throwing Exceptions
- Instead of only printing error messages for invalid input, we could use `throw new IllegalArgumentException("message")` — stops execution with a clear error. More professional and forces the caller to handle invalid cases.


## Lessons Learned from this Project

Mistakes made (and fixed) while building this project:

- Updating `amount` instead of `balance` in deposit/withdraw
- Putting code outside `main` method
- Forgetting quotes around String values
- Wrong order of if/else checks (negative check must come first)
- Using `BigDecimal` before understanding it — stick with `double` for now

New one to watch for future projects:

- Constructor validation: if initial balance is negative, we only print a message but still set `accountNumber` and `accountHolderName`; the balance might stay at default `0.0`. Consider throwing an exception or rejecting the object for invalid initial balance.


## How to Run
```bash
cd bank-account
javac BankAccount.java BankAccountDemo.java
java BankAccountDemo
```
