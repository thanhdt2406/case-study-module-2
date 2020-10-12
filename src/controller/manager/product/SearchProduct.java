package controller.manager.product;

import model.Product;

public interface SearchProduct {
    Product searchByName(String name);
    Product searchByID(String name);
}
