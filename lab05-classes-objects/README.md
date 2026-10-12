# Lab 5 – Classes & Objects: Computer Tracker

A Java program that models computers a company buys for its employees, practicing class design, object creation and method calls.

## Computer class
**Attributes:** person name, purchase cost, CPU speed, age (months), memory size

**Methods:**
- Default constructor, getters and setters, and `setAll()` to update all attributes at once
- `sell()`: calculates the resale price (50% discount if older than 24 months, otherwise 25%)
- `ageInSeconds()`: converts the computer's age from months to seconds
- `upgradeMemory()`: adds memory, without letting the total exceed 256 GB
- `toString()`: returns the computer's details, including its current resale price

## Test program
Creates three `Computer` objects, prints their details, updates one with user input, and tests memory upgrades against the 256 GB limit.

**Concepts:** classes and objects, constructors, encapsulation (getters/setters), instance methods, `toString()`

