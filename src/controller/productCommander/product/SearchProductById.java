package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;
import model.Product;

public class SearchProductById implements Command<Product,Integer> {
    ProductManager manager = ProductManager.getProductManager();

    public SearchProductById(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public Product excuse(Integer i) {
       return manager.searchByID(i.intValue());
    }
}
