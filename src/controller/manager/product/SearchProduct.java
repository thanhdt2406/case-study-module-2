package controller.manager.product;

import model.Product;

import java.util.HashMap;
import java.util.List;

public interface SearchProduct {
   List<Product> searchByName(String name);
    Product searchByID(int id);
}
