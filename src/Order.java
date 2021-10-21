public class Order {
    private ShippingAddress destination;
    private Customer orderedBy;

    public Order(ShippingAddress dest, Customer cust) {
        destination=dest;
        orderedBy=cust;
    }
}
