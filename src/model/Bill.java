package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private int billID;
    private int customerID;
    private int totalPrice;
    private List<Product> productList;
    private static int ID = 0;
    private LocalDate date;

    public Bill() {
    }

    public Bill(int customerID, List<Product> list) {
        this.billID = ID++;
        this.productList = new ArrayList<>();
        this.date = LocalDate.now();
        this.totalPrice = 0;
    }

    public int getBillID() {
        return billID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
        this.totalPrice += product.getPrice();
    }



    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", customerID=" + customerID +
                ", totalPrice=" + totalPrice +
                ", productList=" + productList +
                ", date=" + date +
                '}';
    }
}
