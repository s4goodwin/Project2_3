import java.beans.Customizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private ArrayList<Order> Orders;
    private ArrayList<Customer> Customers;

    public Store(){
        Orders = new ArrayList<Order>();
        Customers = new ArrayList<Customer>();
    }

    public static void main(String [] args){
        var comp152Inc = new Store();
        comp152Inc.runStore();
    }

    public void runStore(){
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

    private void loadStartingCustomers(Scanner inputReader){
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
        
    }
}
