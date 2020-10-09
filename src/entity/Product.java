package entity;

public class Product {
    protected int productID;
    protected String name;
    protected int price;

    public Product() {

    }

<<<<<<< HEAD
    public Product(String name) {
        this.name = name;
    }

    public Product(int productID, String name, int price) {
        this.productID = productID;
=======
    public Product(String name, int price) {
>>>>>>> 600425c260a7ee53f2b4da56c8e14969e84ebfb0
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
    public String toString(){
        return String.format("ID: %-4d |Name: %-10s|Price: %-8d",productID,name,price);
     }
}
