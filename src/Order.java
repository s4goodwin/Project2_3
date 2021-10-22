import java.util.ArrayList;

public class Order {
    private ShippingAddress destination;
    private Customer orderedBy;
    private ArrayList<merchandiseItem> cartForOrder;
    

    public Order(ShippingAddress dest, Customer cust,ArrayList<merchandiseItem> orderCart) {
        destination=dest;
        orderedBy=cust;
        cartForOrder=orderCart;
    }
    public String getDestination(){
        return destination.toString();
    }
    public String getOrderer(){
        return orderedBy.toString();
    }
}
