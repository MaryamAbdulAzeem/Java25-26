# Lab 6 – College Information (Arrays of Objects & Static Members)

A Java program that reads college data from a text file into an array of objects, then displays and analyzes it.

## Classes
- **`College`**: stores a college's name, number of departments, students and faculty members. A **static** counter tracks how many `College` objects have been created. Includes getters, setters, `setAll()` and `toString()`.
- **`CollegeDemo`**: reads each line of `college.txt`, creates a `College` object from it, stores it in an array, and prints every college's details.

## Analysis methods
- `findAvg()`: returns the average number of students per college
- `getMax()`: returns the name of the college with the most faculty members

## Sample output
Colleges' information  
College CCI, number of dept. 3, number of students 2600, number of faculty members 50. 
College MED, number of dept. 3, number of students 1000, number of faculty members 40. 
College ENG, number of dept. 5, number of students 1500, number of faculty members 60. 
The average number of students per college is 1700.00 
The college with the highest number of faculty is ENG 


**Concepts:** arrays of objects, static members, file input with `Scanner` and `FileReader`, exception handling, static methods
