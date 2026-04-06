package dao;

import db.DBConnection;
import java.sql.*;

public class OrderDAO {

    // Place order
    public void placeOrder(int oid, int cid, int pid, int qty) {

        try {
            Connection con = DBConnection.getConnection();

            // Check Customer exists
            PreparedStatement checkCust = con.prepareStatement(
                    "SELECT COUNT(*) FROM Customer WHERE CustomerID = ?");
            checkCust.setInt(1, cid);
            ResultSet rc = checkCust.executeQuery();

            if (rc.next() && rc.getInt(1) == 0) {
                System.out.println("Customer ID not found!");
                return;
            }

            // Check Product exists + get price + stock
            PreparedStatement checkProd = con.prepareStatement(
                    "SELECT Price, Stock FROM Product WHERE ProductID = ?");
            checkProd.setInt(1, pid);
            ResultSet rp = checkProd.executeQuery();

            if (!rp.next()) {
                System.out.println("Product ID not found!");
                return;
            }

            double price = rp.getDouble("Price");
            int stock = rp.getInt("Stock");

            // Check stock availability
            if (qty > stock) {
                System.out.println("Not enough stock available!");
                return;
            }

            double total = price * qty;

            // Insert into Orders
            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO Orders VALUES (?, CURDATE(), ?, ?, ?, 101)");

            ps2.setInt(1, oid);
            ps2.setString(2, "Pending");
            ps2.setDouble(3, total);
            ps2.setInt(4, cid);

            ps2.executeUpdate();

            // Insert into OrderProduct
            PreparedStatement ps3 = con.prepareStatement(
                    "INSERT INTO OrderProduct VALUES (?, ?, ?)");

            ps3.setInt(1, oid);
            ps3.setInt(2, pid);
            ps3.setInt(3, qty);

            ps3.executeUpdate();

            System.out.println("Order placed successfully!");

        } catch (SQLException e) {
            System.out.println("Database error while placing order!");
        } catch (Exception e) {
            System.out.println("Unexpected error!");
        }
    }

    // View all orders
    public void viewOrders() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Orders");

            System.out.println("\n----------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s\n",
                    "OrderID", "Status", "Total Amount");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-15s %-15.2f\n",
                        rs.getInt("OrderID"),
                        rs.getString("Status"),
                        rs.getDouble("TotalAmount"));
            }

            System.out.println("----------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrderStatus(int orderId, String status) {

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE Orders SET Status = ? WHERE OrderID = ?"
        );

        ps.setString(1, status);
        ps.setInt(2, orderId);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Status updated!");
        else
            System.out.println("Order not found!");

    } catch (Exception e) {
        System.out.println("Error updating status!");
    }
}
}