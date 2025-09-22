import java.io.Serializable;

public class Passenger implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization
    private String passengerID;
    private String name;
    private String contactNumber;

    public Passenger(String passengerID, String name, String contactNumber) {
        this.passengerID = passengerID;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Passenger ID: " + passengerID + ", Name: " + name + ", Contact: " + contactNumber;
    }
}