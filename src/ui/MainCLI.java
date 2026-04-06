package ui;

import java.util.Scanner;
import service.*;
import dao.*;
import model.Customer;
import util.InputValidator;
public class MainCLI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService cs = new CustomerService();
        OrderDAO od = new OrderDAO();

        //Polymorphism (interface reference)
        BaseDAO dao = new ProductDAO();  

        ProductDAO pd = new ProductDAO(); // still used for other methods

        while (true) {

            System.out.println("\n==== Inventory System ====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Products");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Check Stock");
            System.out.println("6. Exit");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    Customer c = new Customer();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (!InputValidator.isValidID(id)) {
                        System.out.println("Invalid ID! Must be positive.");
                        break;
                    }
                    c.setId(id);

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    if (!InputValidator.isValidName(name)) {
                        System.out.println("Invalid Name! No numbers allowed.");
                        break;
                    }
                    c.setName(name);

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    if (!InputValidator.isValidEmail(email)) {
                        System.out.println("Invalid Email! Must contain @");
                        break;
                    }
                    c.setEmail(email);

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    if (!InputValidator.isValidPhone(phone)) {
                        System.out.println("Invalid Phone! Must be 10 digits.");
                        break;
                    }
                    c.setPhone(phone);

                    System.out.print("Address: ");
                    c.setAddress(sc.nextLine());

                    cs.addCustomer(c);
                    break;

                case 2:
                    //POLYMORPHISM USED HERE
                    dao.viewAll();  
                    break;

                case 3:
                    System.out.print("Order ID: ");
                    int oid = sc.nextInt();

                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt();

                    System.out.print("Product ID: ");
                    int pid = sc.nextInt();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    od.placeOrder(oid, cid, pid, qty);
                    break;

                case 4:
                    od.viewOrders();
                    break;

                case 5:
                    System.out.print("Enter Product ID: ");
                    int p = sc.nextInt();

                    int stock = pd.checkStock(p);
                    System.out.println("Stock = " + stock);

                    break;
                case 6:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}