## Concepts Learned

### 1. Classes and Objects
- A **class** is a blueprint (BankAccount.java)
- An **object** is an instance created from that blueprint
- `BankAccount account1 = new BankAccount(...)` creates an object

### 2. Access Modifiers
- `private` — only accessible inside the class (fields: accountNumber, balance, etc.)
- `public` — accessible from anywhere (methods: deposit, withdraw, etc.)
- Think of it like an ATM: cash inside is private, buttons are public

### 3. Constructor
- Special method that runs when you create an object with `new`
- Same name as the class, no return type
- Used to initialize fields

### 4. `this` Keyword
- Refers to the current object's field
- `this.balance = balance` means: set the object's balance to the parameter's value

### 5. Encapsulation
- Keep fields `private`, expose `public` methods
- Methods contain validation logic (no negative deposits, insufficient balance checks)
- Prevents direct access like `account1.balance = -99999`

### 6. Return vs Print
- `void` methods do something but return nothing
- `double getBalance()` returns a value — caller decides what to do with it
- `System.out.println()` prints to terminal

### 7. Compilation Flow

```
You write        →  javac compiles  →  java runs
─────────           ──────────────     ─────────
.java files    →    .class files   →   output in terminal
(human code)        (machine code)     (results)
```

- Every `.java` file gets its own `.class` file (one-to-one mapping)

  | Source File | Compiled File |
  |---|---|
  | `BankAccount.java` | `BankAccount.class` |
  | `BankAccountDemo.java` | `BankAccountDemo.class` |

- Changed a `.java` file? Recompile with `javac` before running with `java`
- Compile both files together: `javac BankAccount.java BankAccountDemo.java`

### 8. Validation
- Always validate inputs before modifying data
- Order of checks matters (check negative before checking balance)
- Handle edge cases: negative amounts, zero, insufficient balance, negative initial balance

## Lessons Learned from this Project
- Updating `amount` instead of `balance` in deposit/withdraw
- Putting code outside `main` method
- Forgetting quotes around String values
- Wrong order of if/else checks (negative check must come first)
- Using `BigDecimal` before understanding it — stick with `double` for now

## How to Run
```bash
cd bank-account
javac BankAccount.java BankAccountDemo.java
java BankAccountDemo
```
