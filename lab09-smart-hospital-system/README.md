# Lab 9 – Smart Hospital Management System

A Java program modelling a small hospital system, practicing abstract classes, interfaces, multiple interface implementation and polymorphism.

## Design
- **`Patient`** (abstract class): stores the patient's name and defines `displayInfo()` and the abstract `calculateBill()`.
- **`InPatient`** extends `Patient` and implements **four interfaces** at once:
  - `Admittable`: `admit()`
  - `Monitorable`: `checkVitals()`
  - `Insurable`: `applyInsurance()`, where insurance covers 30% of the treatment cost
  - `Payable`: `payBill()`

## What the program does
Stores patients in a `Patient[]` array, then for each one displays their info, admits them, checks their vitals, calculates their bill after insurance, and adds it to the hospital's total revenue.

**Example:** treatment costs of 1000, 2000 and 1500 AED → `Total Revenue: 3150.0`

**Concepts:** abstract classes and methods, interfaces, multiple interface implementation, polymorphism through a parent-type array

