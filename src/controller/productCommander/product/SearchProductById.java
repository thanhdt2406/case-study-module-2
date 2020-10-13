package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;
import model.Product;

import java.util.List;

public class SearchProductById implements Command<List,Integer> {
    ProductManager manager = ProductManager.getProductManager();

    public SearchProductById(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public List excuse(Integer i) {
        manager.searchByID(i.intValue());
        return null;
    }
}
