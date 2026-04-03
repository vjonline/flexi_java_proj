package ui;

import java.util.Scanner;
import service.*;

public class MainCLI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService cs = new CustomerService();
        ProductService ps = new ProductService();
        OrderService os = new OrderService();

        while (true) {
            System.out.println("\n=== Inventory System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Products");
            System.out.println("3. Place Order");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    cs.addCustomer(id, name, email, phone, address);
                    break;

                case 2:
                    ps.viewProducts();
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

                    os.placeOrder(oid, cid, pid, qty);
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}