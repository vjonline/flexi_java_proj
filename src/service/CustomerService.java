package service;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
    CustomerDAO dao = new CustomerDAO();

    public void addCustomer(Customer c) {
        dao.addCustomer(c);
    }
}