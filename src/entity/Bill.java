package entity;

import java.util.ArrayList;

public class Bill {
    private int billID;
    private int IDseller;
    private int IDcustomer;
    private int totalPrice;

    public Bill() {
    }

    public Bill(int billID, int IDseller, int IDcustomer, int totalPrice) {
        this.billID = billID;
        this.IDseller = IDseller;
        this.IDcustomer = IDcustomer;
        this.totalPrice = totalPrice;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setIDseller(int IDseller) {
        this.IDseller = IDseller;
    }

    public void setIDcustomer(int IDcustomer) {
        this.IDcustomer = IDcustomer;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBillID() {
        return billID;
    }

    public int getIDseller() {
        return IDseller;
    }

    public int getIDcustomer() {
        return IDcustomer;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
