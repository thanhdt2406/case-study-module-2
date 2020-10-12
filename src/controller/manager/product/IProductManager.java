package controller.manager.product;

import model.Product;
import controller.manager.ISearcher;

public interface IProductManager extends ISearcher {
    public void addProduct(Product product);
    public void showProducts();
    public void updateProduct();
    public void deleteProduct();
}
