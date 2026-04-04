package dao;

import db.DBConnection;
import model.Customer;
import java.sql.*;

public class CustomerDAO {

    public void addCustomer(Customer c) {

    try {
        Connection con = DBConnection.getConnection();

        // Using stored procedure
        PreparedStatement ps =
            con.prepareStatement("CALL addCustomer(?,?,?,?,?)");

        // Using getters from model
        ps.setInt(1, c.getId());
        ps.setString(2, c.getName());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getPhone());
        ps.setString(5, c.getAddress());

        ps.execute();

        System.out.println("Customer added successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}