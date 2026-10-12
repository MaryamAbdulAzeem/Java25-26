public class FlightSeatingTest {
    public static void main(String[] args) {
        // Initialization: rows x cols flight seating grid
        boolean[][] flightSeats = new boolean[5][5];

        // Create FlightSeating object
        FlightSeating theFlight = new FlightSeating();

        // Display initial seating
        theFlight.displaySeats(flightSeats);

        System.out.println("\nBooking some seats...\n");

        // Booking seats:
        theFlight.bookSeat(flightSeats, 5, 6); // seat 5,6
        theFlight.bookSeat(flightSeats, 1, 2); // seat 1,2
        theFlight.bookSeat(flightSeats, 3, 4); // seat 3,4
        theFlight.bookSeat(flightSeats, 0, 0); // seat 0,0
        theFlight.bookSeat(flightSeats, 1, 2); // seat 1,2

        System.out.println("\nUpdated Seating Plan:\n");
        theFlight.displaySeats(flightSeats);

        // Display occupancy rate
        double occupancy = theFlight.getOccupancyRate(flightSeats);
        System.out.printf("\nOccupancy Rate: %.2f%%\n", occupancy);
    }
}
