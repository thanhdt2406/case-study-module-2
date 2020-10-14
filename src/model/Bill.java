package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private int billID;
    private String userName;
    private int totalPrice;
    private List<Product> productList = new ArrayList<>();
    private LocalDate date;

    public Bill() {

    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }


    public LocalDate getDate() {
        return date;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("|id: %-5d|Username: %-12s|total price: %-10d",billID, userName,totalPrice);
//        return "Bill{" +
//                "billID=" + billID +
//                ", customerID=" + customerID +
//                ", totalPrice=" + totalPrice +
//                ", productList=" + productList +
//                ", date=" + date +
//                '}';
    }
}
