package Task2;
import java.util.ArrayList;
public class FuelSystem {
    private int FuelStock;
    private FuelQueue[] pumps;
    private ArrayList<String> customers;

    public int getStock() {
        return FuelStock;
    }

    public void setStock(int stock) {
        this.FuelStock = stock;
    }

    public FuelQueue[] getPumps() {
        return pumps;
    }

    public void setPumps(FuelQueue[] pumps) {
        this.pumps = pumps;
    }

    public ArrayList<String> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<String> customers) {
        this.customers = customers;
    }
}
