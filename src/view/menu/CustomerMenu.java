package view.menu;

import controller.manager.customer.Customer;

public class CustomerMenu extends Menu {
    private Customer customer = new Customer();

    public CustomerMenu() {
    }

    public void run(){
        System.out.println("run customer menu");
    }
}
