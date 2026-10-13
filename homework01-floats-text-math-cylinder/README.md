# Homework 1 – Floating-Point Comparison, Text Processing & Cylinder Class

Three Java programs covering numeric precision, string manipulation, the `Math` class and basic class design.

## 1. Floating-Point Comparison
Reads three `double` values and checks two things:
- whether all three are equal when rounded to three decimal places
- whether the largest difference between any two of them is less than 0.001

Shows why comparing floating-point numbers needs care, since rounding and tolerance checks can give different answers.

## 2. Interactive Text & Math Program
Runs in a loop until the user chooses to exit.

**Part A: Text processing.** Takes a sentence of at least six words ending in `!`, then:
1. reverses the k-th word (k > 5)
2. replaces `!` with `$`
3. swaps the case of every letter
4. removes all spaces and prints the result

**Part B: Math menu.** Offers addition, subtraction, multiplication, division, absolute value, power, and rounding to a chosen number of decimal places, asking for the right number of inputs for each.

## 3. Cylinder Class
A `Cylinder` class with radius and height, getters and setters, `getVolume()` (πr²h), `getSurfaceArea()` (2πr² + 2πrh) and an overridden `toString()`. A separate main class reads the dimensions from the user and displays the cylinder's details.

**Concepts:** floating-point precision, `Math.round` / `Math.abs` / `Math.pow`, `String` methods, loops and menus, classes, constructors, encapsulation, `toString()`

