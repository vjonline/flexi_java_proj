package dao;

import db.DBConnection;
import java.sql.*;

public class CustomerDAO {

    public void addCustomer(int id, String name, String email, String phone, String address) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, address);

            ps.executeUpdate();
            System.out.println("Customer added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}