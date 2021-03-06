package view.menu;

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
        do {
            System.out.println("___________________________________________________");
            System.out.println(ADMIN_MENU);
            choice = inputer.inputInt("Your choice: ");
            setupAdminMenu(choice);
        } while (choice != 4);
    }

    public void setupAdminMenu(int choice) {
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
        String BILL_MANAGER_MENU =
                "\n|---BILL MANAGER MENU---|" +
                        "\n|--1. Show all bills----|" +
                        "\n|--2. Delete bill-------|" +
                        "\n|--3. Search bill-------|" +
                        "\n|--4. Back--------------|";

        switch (choice) {
            case 1:
                int productChoice;
                do {
                    System.out.println("___________________________________________________");
                    System.out.println(PRODUCT_MENU);
                    productChoice = inputer.inputInt("Your choice: ");
                    setupProductMenu(productChoice);
                } while (productChoice != 4);
                break;
            case 2:
                int userManagerChoice;
                do {
                    System.out.println("___________________________________________________");
                    System.out.println(USER_MANAGER_MENU);
                    userManagerChoice = inputer.inputInt("Your choice: ");
                    setupUserManagerMenu(userManagerChoice);
                }
                while (userManagerChoice != 4);
                break;
            case 3:
                int billManagerChoice;
                do {
                    System.out.println("___________________________________________________");
                    System.out.println(BILL_MANAGER_MENU);
                    billManagerChoice = inputer.inputInt("Your choice: ");
                    setupManageBillMenu(billManagerChoice);
                }
                while (billManagerChoice != 4);
                break;
            case 5:
                System.out.println("Exit program!!!");
                System.exit(0);
        }
    }

    public void setupProductMenu(int productChoice) {
        switch (productChoice) {
            case 1:
                commander.chooseShowAllProduct();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:
                searchProductByName();
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                searchProductById();
                inputer.inputString("Press enter to continue...");
                break;
        }
    }

    public void setupUserManagerMenu(int userManagerChoice) {
        switch (userManagerChoice) {
            case 1:
                commander.chooseShowAllUser();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:
                String username = inputer.inputString("Enter username: ");
                commander.chooseDeleteUser(username);
                // Delete User
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                username = inputer.inputString("Enter Username: ");
                editUser(username);
                break;
        }
    }

    public void setupManageBillMenu(int choice) {
        switch (choice) {
            case 1:
                billCommander.chooseShowBill();
                inputer.inputString("Press enter to continue...");
                break;
            case 2:
                int id = inputer.inputInt("Enter bill ID: ");
                billCommander.chooseDeleteBill(id);
                System.out.println("Done!");
                inputer.inputString("Press enter to continue...");
                break;
            case 3:
                id = inputer.inputInt("Enter bill ID: ");
                System.out.println(billCommander.chooseSearchBill(id).toString());

                inputer.inputString("Press enter to continue...");
                break;
            default:
                System.out.println("Choose an option!");
        }
    }
}
