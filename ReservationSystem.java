import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class ReservationSystem {
    private Map<String, Flight> flights;
    private static final String DATA_FILE = "flights.dat";

    public ReservationSystem() {
        flights = new HashMap<>();
        loadFlights();
    }

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
        saveFlights();
    }

    public boolean bookFlight(String flightNumber, Passenger passenger) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            boolean booked = flight.bookSeat(passenger);
            if (booked) {
                System.out.println("Booking successful! " + passenger.getName() + " is booked on " + flight.getFlightNumber());
                saveFlights();
                return true;
            } else {
                System.out.println("Sorry, flight " + flightNumber + " is full.");
            }
        } else {
            System.out.println("Flight " + flightNumber + " not found.");
        }
        return false;
    }

    public boolean cancelReservation(String flightNumber, Passenger passenger) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            boolean cancelled = flight.cancelBooking(passenger);
            if (cancelled) {
                System.out.println("Reservation for " + passenger.getName() + " on " + flight.getFlightNumber() + " cancelled successfully.");
                saveFlights();
                return true;
            } else {
                System.out.println("Passenger " + passenger.getName() + " not found on this flight.");
            }
        } else {
            System.out.println("Flight " + flightNumber + " not found.");
        }
        return false;
    }

    public void displayAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available in the system.");
        } else {
            System.out.println("\n--- All Available Flights ---");
            flights.values().forEach(System.out::println);
        }
    }

    public void searchFlights(String origin, String destination) {
        System.out.println("\n--- Search Results from " + origin + " to " + destination + " ---");
        List<Flight> results = flights.values().stream()
                .filter(f -> f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("No flights found for this route.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void saveFlights() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(flights);
        } catch (IOException e) {
            System.out.println("Error saving flights: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFlights() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            flights = (Map<String, Flight>) ois.readObject();
            System.out.println("Flights loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous flight data found. Starting with a new system.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading flights: " + e.getMessage());
        }
    }
}