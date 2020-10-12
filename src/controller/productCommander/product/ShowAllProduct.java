package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;

import java.util.HashMap;

public class ShowAllProduct implements Command {
    ProductManager manager = new ProductManager();

    public ShowAllProduct(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public HashMap excuse(Object o) {
        manager.showProducts();
        return null;
    }
}
