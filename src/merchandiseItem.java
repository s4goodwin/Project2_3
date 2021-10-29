public class merchandiseItem {
    private String Name;
    private double price;
    private ItemType taxibleItem;

    public merchandiseItem(String Name,double price, ItemType type){
        this.Name=Name;
        this.price=price;
        taxibleItem=type;
    }
    //below are the three get methods, they just return each of the values
    public String getName(){
        return Name;
    }
    public double getPrice() {
        return price;
    }
    public ItemType getType() {
        return taxibleItem;
    }
}
