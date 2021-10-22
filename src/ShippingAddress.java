public class ShippingAddress {
    private String AddressLine1;
    private String AddressLine2;
    private String City;
    private String State;
    private String PostalCode;

    public ShippingAddress(String line1, String line2, String city, String state, String postCode){
        AddressLine1 = line1;
        AddressLine2 = line2;
        City=city;
        this.State=state;
        PostalCode=postCode;
    }
    public String toString(){
        if (AddressLine2.length()>0)
            return AddressLine1+'\n'+AddressLine2+"\n"+City+", "+State+" "+PostalCode;
        return AddressLine1+'\n'+City+", "+State+" "+PostalCode;
    }
}
