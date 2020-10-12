package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;

import java.util.HashMap;

public class SearchProductByName implements Command<String> {
    ProductManager manager = new ProductManager();

    public SearchProductByName(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public HashMap excuse(String o) {
        return manager.searchByName(o);
    }
}
