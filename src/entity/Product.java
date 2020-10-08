package entity;

public class Product {
    protected int productID;
    protected String name;
    protected String brand;
    protected int price;
    protected int numbersOfproduct;

    public Product() {
    }

    public Product(int productID, String name, String brand, int price) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public void setNumbersOfproduct(int numbersOfproduct) {
        this.numbersOfproduct = numbersOfproduct;
    }

    public int getNumbersOfproduct() {
        return numbersOfproduct;
    }
}
