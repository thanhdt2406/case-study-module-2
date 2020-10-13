package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;
import model.Product;

import java.util.List;

public class ShowAllProduct implements Command {
    ProductManager manager = ProductManager.getProductManager();

    public ShowAllProduct(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Product> excuse(Object o) {
        manager.showProducts();
        return null;
    }
}
