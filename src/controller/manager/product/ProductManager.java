package controller.manager.product;

import controller.io.DataURLManager;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager {
    private List<Product> products = new ArrayList<>();
    private int nextID;

    public ProductManager() {
        DataURLManager dataURLManager = new DataURLManager();
        try {
            products = dataURLManager.getData(DataURLManager.IPHONE_URL, DataURLManager.PRODUCT_REGEX, DataURLManager.PRICE_REGEX);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getNextID() {
        nextID = products.get(products.size() - 1).getProductID();
        return nextID+1;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void showProducts() {
        for (Product ele : products) {
            System.out.println(ele.toString());
        }
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }


}
