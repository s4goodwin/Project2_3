public class Order {
    private ShippingAddress destination;
    private Customer orderedBy;

    public Order(ShippingAddress dest, Customer cust) {
        destination=dest;
        orderedBy=cust;
    }
    public String getDestination(){
        return destination.toString();
    }
    public String getOrderer(){
        return orderedBy.toString();
    }
}
