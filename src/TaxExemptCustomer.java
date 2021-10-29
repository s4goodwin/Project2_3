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
        System.out.println("Please contact "+getName()+" on the day of delivery");  //just prints out a text with the
    }                                                                               //getname method implemented

    @Override
    public double payForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        double sum = 0;                                                //this is the same as residential customer, except
        for(merchandiseItem item : itemsInOrder)                         //in the return i dont add a taxrate
            sum += item;
        return sum;
    }
}
