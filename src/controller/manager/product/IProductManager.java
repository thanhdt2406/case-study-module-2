package controller.manager.product;

import model.Product;

public interface IProductManager{
    public void addProduct(Product product);
    public void showProducts();
    public void updateProduct(int id);
    public void deleteProduct();
}
