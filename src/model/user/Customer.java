package model.user;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    public Customer() {
    }

    private List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
