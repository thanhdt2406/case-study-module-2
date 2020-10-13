package view.menu;

import controller.manager.customer.Customer;
import model.User;

import java.util.List;

public class CustomerMenu extends Menu {
    private final String CUSTOMER_MENU = "|--1. Search product-------|" +
            "\n|--2. Add product to cart--|" +
            "\n|--3. Pay -----------------|" +
            "\n|--4. Show history---------|" +
            "\n|--5. Edit acoount --------|" +
            "\n|--6. Back ----------------|";
    private final String EDIT_MENU = "|--1. Change password-------|" +
            "|--2. Edit full name--------|" +
            "|--3. Edit phone number-----|" +
            "|--4. Edit address----------|" +
            "|--4. Edit all--------------|" +
            "|--5. Back";
    private final String SEARCH_MENU = "|--1. Search by name------|" +
            "\n|--2. Search by id----|" +
            "\n|--3 Add to cart------|";
    //private Customer customer = new Customer();
    private User customer = userManager.getCurrentUser();


    public CustomerMenu() {
    }

    public void run() {
        int choice;
        do {
            System.out.println(CUSTOMER_MENU);
            choice = inputer.inputInt("Your choice: ");
            setUpCusTomerMenu(choice);
        }while (choice!=6);


    }

    public void setUpCusTomerMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("search product");
                break;
            case 2:
                System.out.println("add ti cart");
                //customer.cart.add(product);
                break;
            case 3:
                comander.chooseShowAllProduct();
                System.out.println("buy product");
                break;
            case 4:
                System.out.println("show bill");
                break;
            case 5:
                System.out.println("update account");
                break;
            default:
                System.out.println("choose an option!");
        }
    }

    public void setupEDIT_MENU(int choice){
        switch (choice){
            case 1:
                System.out.println("change password");
                break;
            case 2:
                System.out.println();
            case 3:
            case 4:
            case 5:
        }
    }
}
