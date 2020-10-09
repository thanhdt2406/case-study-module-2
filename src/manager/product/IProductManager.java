package manager.product;

import entity.Product;
import manager.IManager;

public interface IProductManager extends IManager {
    public void addProduct(Product product);
    public void showProducts();
}
