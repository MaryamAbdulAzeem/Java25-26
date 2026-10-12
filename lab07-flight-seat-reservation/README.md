# Lab 7 (similar scenario) Flight Seat Reservation System (2D Arrays)

A Java program that models a flight's seating plan as a 2D boolean array, where `false` means available and `true` means booked. Adapted from a cinema booking lab exercise.

## FlightSeating class
- `displaySeats()`: prints the seating grid, using `O` for available seats and `X` for booked seats
- `bookSeat()`: reserves a seat by row and column, rejecting invalid positions and seats that are already booked
- `getOccupancyRate()`: returns the percentage of booked seats, using an enhanced `for` loop

## Test program
**`FlightSeatingTest`** creates a 5×5 seating plan, displays the empty plan, reserves a series of seats (including an invalid position and a double booking), then shows the updated plan and occupancy rate.

Example result after booking: `Occupancy Rate: 12.00%`

**Concepts:** 2D arrays, passing arrays to methods, input validation, enhanced `for` loops

