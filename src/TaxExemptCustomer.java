import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String Name, int ID) {
        super(Name, ID);
    }

    public TaxExemptCustomer(String custName) {
        super(custName);
    }


    }

    @Override
    public double payForOrder(ArrayList<merchandiseItem> List) {
        return 0;
    }
}
