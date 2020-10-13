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
            "\n|--2. Edit full name--------|" +
            "\n|--3. Edit phone number-----|" +
            "\n|--4. Edit address----------|" +
            "\n|--5. Edit all--------------|" +
            "\n|--6. Back";
    private final String SEARCH_MENU = "|--1. Search by name------|" +
            "\n|--2. Search by id----|" +
            "\n|--3 Add to cart------|" +
            "\n|--4. Back------------|";
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
        } while (choice != 6);
    }

    public void setUpCusTomerMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("search product");
                int choice1;
                do {
                    System.out.println(SEARCH_MENU);
                    choice1 = inputer.inputInt("Your choice: ");
                    setupSEARCH_MENU(choice1);
                } while (choice1 != 4);
                break;
            case 2:
                System.out.println("add ti cart");
                break;
            case 3:
                System.out.println("buy product");
                break;
            case 4:
                System.out.println("show bill");
                break;
            case 5:
                System.out.println("update account");
                do {
                    System.out.println(EDIT_MENU);
                    choice1 = inputer.inputInt("Your choice: ");
                    setupEDIT_MENU(choice1);
                } while (choice1 != 6);
                break;
            default:
                System.out.println("choose an option!");
        }
    }

    public void setupEDIT_MENU(int choice) {
        switch (choice) {
            case 1:
                System.out.println("change password");
                break;
            case 2:
                System.out.println("edit name");
                break;
            case 3:
                System.out.println("edit phone number");
                break;
            case 4:
                System.out.println("edit address");
            case 5:
                System.out.println("edit all");
                break;
            default:
                System.out.println("choose an option!");
        }
    }

    public void setupSEARCH_MENU(int choice) {
        switch (choice) {
            case 1:
                System.out.println("search by name");
                break;
            case 2:
                System.out.println("search by id");
                break;
            case 3:
                System.out.println("add to cart");
                break;
            default:
                System.out.println("Choose an option!");
        }
    }
}
