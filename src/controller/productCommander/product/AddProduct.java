package controller.productCommander.product;

import controller.productCommander.Command;
import model.Product;
import controller.manager.product.ProductManager;

import java.util.HashMap;

public class AddProduct implements Command<Product> {

    ProductManager manager;

    public AddProduct(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public HashMap excuse(Product product) {
        manager.addProduct(product);
        return null;
    }

}
