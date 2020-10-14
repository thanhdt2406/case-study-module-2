package model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, int price) {
        this.productID = id;
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d |Name: %-60s|Price: %-8d", productID, name, price);
    }
}
