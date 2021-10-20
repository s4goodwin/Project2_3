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
            if(currentCustomer.getCustomerID())
        }
    }
}
