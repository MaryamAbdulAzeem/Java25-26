public class FlightSeating {
    public FlightSeating() {
    }

    // Method to display seating layout
    public void displaySeats(boolean[][] seats) {
        System.out.println("Flight Seating Plan (O = Available, X = Booked)");
        for (int i = 0; i < seats.length; i++) { // loop rows
            for (int j = 0; j < seats[i].length; j++) { // loop columns
                if (seats[i][j]) { // if the seat is booked,
                    System.out.print("X" + " ");
                } else {
                    System.out.print("O" + " ");
                }
            }
            System.out.println();
        }
    }

    // Method to book a seat
    public void bookSeat(boolean[][] seats, int row, int col) {
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[row].length) {
            if (seats[row][col]) { // if the seat is booked,
                System.out.println("Seat already booked!");
            } else {
                System.out.println("Seat booked successfully at Row " + row + ", Column " + col);
                seats[row][col] = true; // updates the seat availability
            }
        } else {
            System.out.println("Invalid seat position!");
        }
    }

    // Method to calculate
