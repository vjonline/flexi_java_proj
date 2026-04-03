package service;

import dao.OrderDAO;

public class OrderService {
    OrderDAO dao = new OrderDAO();

    public void placeOrder(int orderId, int custId, int productId, int qty) {
        dao.placeOrder(orderId, custId, productId, qty);
    }
}