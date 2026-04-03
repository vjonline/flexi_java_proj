package model;

public class Order {

    private int orderID;
    private String orderDate;
    private String status;
    private double totalAmount;
    private int customerID;
    private int storeManagerID;

    // Getters and Setters
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getStoreManagerID() {
        return storeManagerID;
    }

    public void setStoreManagerID(int storeManagerID) {
        this.storeManagerID = storeManagerID;
    }
}