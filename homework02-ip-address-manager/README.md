# Homework 2 – IP Address Manager

An interactive Java program for managing a list of IP addresses, modelled on the kind of tool an internet service provider might use. Practices class design, static vs. instance members, and working with arrays of objects.

## IPAddress class
Stores an IPv4 address (e.g. `255.123.60.91`) as four parts.
- **Default constructor:** sets all four parts to 0
- **Parameterized constructor:** takes the full address as one string, splits it into four parts, and sets any part outside 0–255 to 0
- A method to set all four parts in one statement, plus getters for each part
- A **static counter** tracking the total number of `IPAddress` objects created
- `PrintIP()`: displays the address in dotted format

## Test program
Reads IP addresses from the keyboard until a sentinel value (`-1`) is entered, skipping duplicates, and stores up to 100 addresses in an array. Then offers a menu to:
1. Search for a specific IP address
2. Count how many addresses start with a given value
3. Print all IP addresses
4. Delete an IP address
5. Save all addresses to a file (name chosen by the user)
6. Exit

**Concepts:** classes and objects, static and instance members, constructors, input validation, string splitting, arrays of objects, file output


