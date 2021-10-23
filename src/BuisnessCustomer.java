import javax.lang.model.element.Name;

public class BuisnessCustomer extends Customer {

    private double purchaseOrderBalance;

    public BuisnessCustomer(String Name, int ID,double purchaseOrderBalance) {
        super(Name, ID);
        this.purchaseOrderBalance=purchaseOrderBalance;
    }
}
}
