package manager;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IManager {

    List<Product> productList = new ArrayList<>();

    @Override
    public boolean create() {
        Product newP = new Product();
        return false;
    }

    @Override
    public void read() {
        for (Product ele : productList){
            System.out.println(ele.toString());
        }
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
