package model;

public class Product {
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


    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
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
