package controller.manager.product;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IProductManager {
   private List<Product> products = new ArrayList<>();
    private int numbersOfproduct;

    public ProductManager() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setNumbersOfproduct(int numbersOfproduct) {
        this.numbersOfproduct = numbersOfproduct;
    }

    public int getNumbersOfproduct() {
        return numbersOfproduct;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void showProducts() {
        for (Product ele : products){
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
