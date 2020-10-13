package model;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {
    private int userID;
    private String fullName;
    private int phoneNumber;
    private String address;
    private int role;
    private String userName;
    private String password;


    public final static int ROLE_CUSTOMER = 0;
    public final static int ROLE_ADMIN = 1;

    public User() {
        this.role = ROLE_CUSTOMER;
    }

    public User(String username) {
        this.userName = username;
    }

    public User(String userName, String password,String fullName, int phoneNumber, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
