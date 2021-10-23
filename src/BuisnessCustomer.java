import jdk.jfr.Name;

import java.util.ArrayList;
import java.util.List;

public class BuisnessCustomer extends Customer {

    private double purchaseOrderBalance;

    public BuisnessCustomer(String Name, int ID,double purchaseOrderBalance) {
        super(Name, ID);
        this.purchaseOrderBalance=purchaseOrderBalance;
    }

    public double payOutstandingBalance


    @Override
    public double payForOrder(ArrayList<merchandiseItem> List) {
        return 0;
    }
}


