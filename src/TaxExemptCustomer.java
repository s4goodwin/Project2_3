import java.util.ArrayList;

public class TaxExemptCustomer extends Customer{
    public TaxExemptCustomer(String Name, int ID) {
        super(Name, ID);
    }

    public TaxExemptCustomer(String custName) {
        super(custName);
    }

    @Override
    public void arrangeDelivery() {
        System.out.println("Please contact "+getName()+" on the day of delivery");
    }

    @Override
    public double payForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        double sum = 0;
        for(merchandiseItem item : itemsInOrder)
            sum += item;
        return sum;
    }
}
