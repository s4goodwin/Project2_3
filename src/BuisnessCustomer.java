import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Optional;
import java.util.jar.Attributes;

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
    public void arrangeDelivery(){
        System.out.println(getName()+" , all deliveries must be from 9-5 Mon-Fri");
    }


    @Override
    public double payForOrder(ArrayList<merchandiseItem> List) {
        return 0;
    }
}


