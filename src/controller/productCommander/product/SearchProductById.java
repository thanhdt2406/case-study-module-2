package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;

import java.util.HashMap;

public class SearchProductById implements Command<Integer> {
    ProductManager manager = new ProductManager();

    public SearchProductById(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public HashMap excuse(Integer i) {
        manager.searchByID(i.intValue());
        return null;
    }
}
