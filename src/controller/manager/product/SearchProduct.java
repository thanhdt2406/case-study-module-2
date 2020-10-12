package controller.manager.product;

import model.Product;

import java.util.HashMap;

public interface SearchProduct {
    HashMap<Integer, Product> searchByName(String name);
    Product searchByID(int id);
}
