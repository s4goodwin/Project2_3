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
        double sum = 0;                           //this is suppose to add up all the values in the arraylist
        for(merchandiseItem item : itemsInOrder)  //i had trouble with the variables, so i dont think something is compatable
            sum += item;                          //maybe i had to convert merchandiceItem to a double?
        return sum*1.0625;


    }
}
