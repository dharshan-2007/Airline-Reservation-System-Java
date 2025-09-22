import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Airline Reservation System Menu ---");
            System.out.println("1. Add a new flight");
            System.out.println("2. Display all flights");
            System.out.println("3. Search for flights");
            System.out.println("4. Book a flight");
            System.out.println("5. Cancel a reservation");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addFlight(system, scanner);
                    break;
                case 2:
                    system.displayAllFlights();
                    break;
                case 3:
                    searchFlights(system, scanner);
                    break;
                case 4:
                    bookFlight(system, scanner);
                    break;
                case 5:
                    cancelReservation(system, scanner);
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }

    private static void addFlight(ReservationSystem system, Scanner scanner) {
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter date (e.g., DD/MM/YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter time (e.g., HH:MM): ");
        String time = scanner.nextLine();
        System.out.print("Enter total seats: ");
        int totalSeats = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        system.addFlight(new Flight(flightNumber, origin, destination, date, time, totalSeats));
        System.out.println("Flight " + flightNumber + " added successfully!");
    }

    private static void searchFlights(ReservationSystem system, Scanner scanner) {
        System.out.print("Enter origin city: ");
        String origin = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine();
        system.searchFlights(origin, destination);
    }

    private static void bookFlight(ReservationSystem system, Scanner scanner) {
        System.out.print("Enter flight number to book: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String passengerID = scanner.nextLine();
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        Passenger passenger = new Passenger(passengerID, name, contactNumber);
        system.bookFlight(flightNumber, passenger);
    }

    private static void cancelReservation(ReservationSystem system, Scanner scanner) {
        System.out.print("Enter flight number to cancel reservation on: ");
        String flightNumber = scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String passengerID = scanner.nextLine();
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        Passenger passenger = new Passenger(passengerID, name, contactNumber);
        system.cancelReservation(flightNumber, passenger);
    }
}