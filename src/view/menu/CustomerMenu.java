package view.menu;

import controller.manager.customer.Customer;

public class CustomerMenu extends Menu {
    private final String CUSTOMER_MENU = "|--1. Show";
    private Customer customer = new Customer();

    public CustomerMenu() {
    }

    public void run(){
        comander.chooseShowAllProduct();
        System.out.println(CUSTOMER_MENU);
    }
}
