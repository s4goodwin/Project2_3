import java.util.ArrayList;

public class ResidentialCustomer extends Customer{
    public ResidentialCustomer(String Name, int ID) {
        super(Name, ID);
    }

    public ResidentialCustomer(String custName) {
        super(custName);
    }



    @Override
    public double payForOrder(ArrayList<merchandiseItem> List) {
        return 0;
    }
}
