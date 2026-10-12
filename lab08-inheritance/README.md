# Lab 8 – Inheritance & Polymorphism

Two Java programs practicing superclasses and subclasses, the `extends` keyword, `super(...)` constructor calls, and method overriding.

## 1. Bank Accounts (`bank-accounts/`)
- **`BankAccount`**: stores an owner name and a non-negative balance, with `deposit()` and `withdraw()` methods that reject invalid amounts and overdrafts.
- **`SavingsAccount`** extends `BankAccount`: adds a profit rate and an `applyProfit()` method, and builds on the parent's `toString()`.

**Example:** `Savings[Sara, $3000.00, rate=2.50%]` → after profit: `Savings[Sara, $3075.00, rate=2.50%]`

## 2. Shapes & Areas (`shapes/`)
A three-level class hierarchy: **`Shape` → `Rectangle` → `Square`**.
- `Rectangle` overrides `getArea()`; `Square` reuses it by passing its side as both width and height.
- The program stores both shapes in a `Shape[]` array and prints each one, demonstrating **polymorphism**.

**Example:** `Square[color=green, side=4.00, area=16.00]`

**Concepts:** inheritance, `extends`, `super(...)`, method overriding, polymorphism, input validation

