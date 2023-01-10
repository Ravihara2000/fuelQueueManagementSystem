package Task2;

import java.util.Queue;
public class Passenger {
    private String firstName;
    private String secondName;
    private String vehicleNo;
    private int requiredLiters;

    public Passenger(String firstName, String secondName, String vehicleNo, int requiredLiters) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNo = vehicleNo;
        this.requiredLiters = requiredLiters;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getRequiredLiters() {
        return requiredLiters;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, secondName);
    }
}
