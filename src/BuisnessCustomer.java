import java.util.ArrayList;
import java.util.Optional;

public class BuisnessCustomer extends Customer {

    private double purchaseOrderBalance;

    public BuisnessCustomer(String Name, int ID,double purchaseOrderBalance) {
        super(Name, ID);
        this.purchaseOrderBalance=purchaseOrderBalance;
    }

    public double payOutstandingBalance(){
        var discountBalance =1000;
        var outstandingBalance=0;
        if (purchaseOrderBalance > discountBalance)
            return purchaseOrderBalance*.95;
        purchaseOrderBalance=outstandingBalance;
        return purchaseOrderBalance;
    }


    @Override
    public double payForOrder(ArrayList<merchandiseItem> List) {
        return 0;
    }
}


