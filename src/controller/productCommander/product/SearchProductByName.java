package controller.productCommander.product;

import controller.manager.product.ProductManager;
import controller.productCommander.Command;
import model.Product;

import java.util.List;

public class SearchProductByName implements Command<String> {
    ProductManager manager = new ProductManager();

    public SearchProductByName(ProductManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Product> excuse(String o) {
        return manager.searchByName(o);
    }
}
