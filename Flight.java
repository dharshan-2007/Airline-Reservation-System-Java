import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization
    private String flightNumber;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int totalSeats;
    private int availableSeats;
    private List<Passenger> bookedPassengers;

    public Flight(String flightNumber, String origin, String destination, String date, String time, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.bookedPassengers = new ArrayList<>();
    }

    // Getters
    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    // Booking methods
    public boolean bookSeat(Passenger passenger) {
        if (availableSeats > 0) {
            bookedPassengers.add(passenger);
            availableSeats--;
            return true;
        }
        return false;
    }

    public boolean cancelBooking(Passenger passenger) {
        if (bookedPassengers.removeIf(p -> p.getPassengerID().equals(passenger.getPassengerID()))) {
            availableSeats++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination +
               " on " + date + " at " + time +
               " (Available Seats: " + availableSeats + "/" + totalSeats + ")";
    }

    public List<Passenger> getBookedPassengers() {
        return bookedPassengers;
    }
}