package view.menu;

import java.util.List;


public class AdminMenu extends Menu {

    public AdminMenu() {
    }

    public void run() {
        String ADMIN_MENU =
                         "\n|--------ADMIN MENU--------|" +
                         "\n|--1. Product management---|" +
                         "\n|--2. User management------|" +
                         "\n|--3. Bill management------|" +
                         "\n|--4. Log out--------------|" +
                         "\n|--5. Exit-----------------|";
        int choice;
        do{
            System.out.println("___________________________________________________");
            System.out.println(ADMIN_MENU);
            choice = inputer.inputInt("Your choice: ");
            setUpMainMenu(choice);
        } while (choice != 4);
    }

    public void setUpMainMenu(int choice) {
        String PRODUCT_MENU =
                "\n|-----PRODUCT MENU-----|" +
                "\n|--1. Show products----|" +
                "\n|--2. Search by name---|" +
                "\n|--3. Search by ID-----|" +
                "\n|--4. Back-------------|";
        String USER_MANAGER_MENU =
                "\n|---USER MANAGER MENU---|" +
                "\n|--1. Show all users----|" +
                "\n|--2. Delete user-------|" +
                "\n|--3. Update user-------|" +
                "\n|--4. Back--------------|";
        switch (choice) {
            case 1:
                int productChoice;
                do{
                    System.out.println("___________________________________________________");
                    System.out.println(PRODUCT_MENU);
                    productChoice = inputer.inputInt("Your choice: ");
                    setupProductMenu(productChoice);
                } while (productChoice != 4);
                break;
            case 2:
                int userManagerChoice;
                do{
                    System.out.println("___________________________________________________");
                    System.out.println(USER_MANAGER_MENU);
                    userManagerChoice = inputer.inputInt("Your choice: ");
                    setupManageUserMenu(userManagerChoice);
                }
                while (userManagerChoice != 4);
                break;
            case 3:
                //????????????????????
                break;
            case 5:
                System.out.println("Exit program!!!");
                System.exit(0);
            default:
                System.out.println("No choice! Try again :D");
        }
    }

    public void setupProductMenu(int productChoice) {
        switch (productChoice) {
            case 1:
                comander.chooseShowAllProduct();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:
                setSearchProductByName();
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                setSearchProductById();
                inputer.inputString("Press enter to continue...");
                break;
        }
    }

    public void setupManageUserMenu(int userManagerChoice) {
        switch (userManagerChoice) {
            case 1:
                comander.chooseShowAllUser();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:

                // Delete User

                inputer.inputString("Press enter to continue...");
                break;
            case 3:

                // Update User

                inputer.inputString("Press enter to continue...");
                break;
        }
    }

    public void setupManageBillMenu() {
        // Bill Manager
    }
}
