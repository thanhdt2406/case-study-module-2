package model;

import java.io.Serializable;

public class User implements Serializable {
    private String fullName;
    private int phoneNumber;
    private String address;
    private String userName;
    private String password;

    private Bill currentBill;

    private boolean isAdmin;

    public User() {
        this.currentBill = new Bill();
        this.isAdmin = false;
    }

    public User(String userName, String password,String fullName, int phoneNumber, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getRole() {
        return isAdmin;
    }

    public void setRole(boolean role) {
        this.isAdmin = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentBill(Bill currentBill) {
        this.currentBill = currentBill;
    }

    public Bill getCurrentBill() {
        return currentBill;
    }

    @Override
    public String toString(){
        return String.format("|Username: %-12s|Password: %-12s\n|Full name: %-30s\n|Phone number:%-15d\n|Address: %-50s",userName,password,fullName,phoneNumber,address);
    }
}
