package command;

import entity.Product;
import manager.product.ProductManager;

public class AddProduct implements Command<Product> {

    ProductManager manager;

    public AddProduct(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public void excuse(Product product) {
        manager.addProduct(product);
    }

}
