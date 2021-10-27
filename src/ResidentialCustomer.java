import java.util.ArrayList;

public class ResidentialCustomer extends Customer{
    public ResidentialCustomer(String Name, int ID) {
        super(Name, ID);
    }

    public ResidentialCustomer(String custName) {
        super(custName);
    }



    @Override
    public double payForOrder(ArrayList<merchandiseItem> itemsInOrder) {
        double sum = 0;
        for(merchandiseItem item : itemsInOrder)
            sum += item;
        return sum*1.0625;


    }
}
