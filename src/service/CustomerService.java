package service;

import dao.CustomerDAO;

public class CustomerService {
    CustomerDAO dao = new CustomerDAO();

    public void addCustomer(int id, String name, String email, String phone, String address) {
        dao.addCustomer(id, name, email, phone, address);
    }
}