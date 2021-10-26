import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;
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
    public double payForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        System.out.println("This order is for "+getName()+" and will be payed with a purchase order");
        double sum = 0;
        for(merchandiseItem item : itemsInOrder)
            sum += item;
            purchaseOrderBalance=sum*1.0625;
            return 0;
    }
}


