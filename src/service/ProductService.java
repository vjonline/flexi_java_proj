package service;

import dao.ProductDAO;

public class ProductService {
    ProductDAO dao = new ProductDAO();

    public void viewProducts() {
        dao.viewProducts();
    }
}