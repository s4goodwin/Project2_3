import java.beans.Customizer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Store {

    private ArrayList<Order> Orders;
    private ArrayList<Customer> Customers;

    public Store(){
        Orders = new ArrayList<Order>();
        Customers = new ArrayList<Customer>();
    }

    public static void main(String [] args) throws IOException {
        var comp152Inc = new Store();
        comp152Inc.runStore();
    }

    public void runStore() throws IOException {
        var inputReader = new Scanner(System.in);
        loadStartingCustomers(inputReader);
        while(true){
            printMainMenu();
            var userChoice = inputReader.nextInt();
            switch (userChoice){
                case 1:
                    addCustomer(inputReader);
                    break;
                case 2:
                    var selectedCustomer = selectCustomer(inputReader);
                    if(selectedCustomer.isPresent())
                        manageCustomer(selectedCustomer.get());
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("\n ### Invalid Selection, please choose option from menu ###");
            }
        }
    }

    private void loadStartingCustomers(Scanner inputReader) throws IOException {
        Path fullPathName;
        String fileName;
        while(true){
            System.out.println("Enter the name of file to load customers:");
            fileName= inputReader.nextLine();
            fullPathName= Paths.get(fileName);
            if (!Files.exists(fullPathName)){
                System.out.println("No file exists, please try another");
            }
            else
                break;
        }
        var allLines = Files.readAllLines(fullPathName);
        for (var line:allLines){
            var splitLine = line.split(",");
            var currentCustomer = new Customer(splitLine[0], Integer.parseInt(splitLine[1]));
            Customers.add(currentCustomer);
        }
    }
    private static void printMainMenu(){
        System.out.println("======================");
        System.out.println("What would you like to do?");
        System.out.println("   [1] Add customer");
        System.out.println("   [2] Select customer");
        System.out.println("   [3] Exit the program");
        System.out.println("======================");
    }
    public void addCustomer(Scanner inputReader){
        inputReader.nextLine();
        System.out.println("Enter the new customer's name:");
        var newName = inputReader.nextLine();
        var newCustomer = new Customer(newName);
        Customers.add(newCustomer);
        System.out.println("Finished adding new customer");
    }
    public Optional<Customer>selectCustomer(Scanner reader){
        var enteredID = reader.nextInt();
        for (var currentCustomer: Customers){
            if(currentCustomer.getCustomerID()==enteredID)
                return Optional.of(currentCustomer);
        }
        System.out.println("No customer with customer ID: "+enteredID);
        return Optional.empty();
    }
    public void manageCustomer(Customer selectedCustomer){
        Scanner secondScanner= new Scanner(System.in);
        while (true){
            printCustomerMenu(selectedCustomer.getName());
            var userChoice = secondScanner.nextInt();
            switch (userChoice){
                case 1:
                    addAddress(secondScanner);
                    break;
                case 2:
                    ShippingAddress selectedAddress = pickAddress(secondScanner,selectedCustomer);
                    makeOrder(selectedAddress,selectedCustomer);
                case 3:
                    return;

                default:
                    System.out.println("Invalid option selected");
            }
        }
    }
    private void printCustomerMenu(String custName){
        System.out.println("======================");
        System.out.println("What do you want to do for Customer " + custName+"?");
        System.out.println("   [1] Add Address to customer");
        System.out.println("   [2] Make an order for the customer");
        System.out.println("   [3] return to the main menu");
        System.out.println("======================");
        System.out.print("Enter the number of your choice:");
    }
    private void addAddress(Scanner secondScanner, Customer selectedCustomer){
        System.out.println("Adding new address for"+selectedCustomer.getName());
        secondScanner.nextLine();
        System.out.println("Enter address line 1:");
        var line1=secondScanner.nextLine();
        System.out.println("Enter address line 2 or <enter> if none:");
        var line2= secondScanner.nextLine();
        System.out.println("Enter City:");
        var city=secondScanner.nextLine();
        System.out.println("Enter State:");
        var state= secondScanner.nextLine();
        System.out.println("Enter postal code");
        var postCode = secondScanner.nextLine();
        var newAddress= new ShippingAddress(line1,line2,city,state,postCode);
    }
    private ShippingAddress pickAddress(Scanner secondScanner, Customer selectedCustomer){
        var customerAddresses = selectedCustomer.getAddresses();
        if (customerAddresses.size()==0){
            System.out.println("No addresses on file, please add an address");
            addAddress(secondScanner,selectedCustomer);
            return selectedCustomer.getAddresses().get(0);
        }
        var count =0;
        System.out.println("Please select a shipping address from on file");
        for (var address : customerAddresses){
            System.out.print("[" + count + "]"); //but you could do for(int count; count < customerAddresses.size(); count++ for the same effect
            System.out.println(address.toString());
            count++;
        }
        System.out.println("Enter the number of the address for order");
        var addressNum = secondScanner.nextInt();
        if (addressNum>= customerAddresses.size()){
            System.out.println("Invalid entry, defaulting to first address on file");
            return customerAddresses.get(0);
        }
        else
            return customerAddresses.get(addressNum);
    }
}
