import java.util.ArrayList;

public class Customer {
    private ArrayList<ShippingAddress> Addresses;
    private String Name;
    private int customerID;


    public Customer(String Name, int ID) {
        this.Name=Name;
        customerID=ID;
        Addresses=new ArrayList<ShippingAddress>();
    }

    public Customer(String custName) {
    }

    public int getCustomerID() {
    }

    public String getName() {
    }

    public ArrayList<ShippingAddress> getAddresses() {
        return new ArrayList<ShippingAddress>(Addresses);
    }
}
