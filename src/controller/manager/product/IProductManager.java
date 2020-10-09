package controller.manager.product;

import model.Product;
import controller.manager.IManager;

public interface IProductManager extends IManager {
    public void addProduct(Product product);
    public void showProducts();
}
