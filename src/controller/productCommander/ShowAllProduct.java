package controller.productCommander;

import controller.manager.product.ProductManager;

public class ShowAllProduct implements Command {
    ProductManager manager = new ProductManager();

    public ShowAllProduct(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public void excuse(Object o) {
        manager.showProducts();
    }
}