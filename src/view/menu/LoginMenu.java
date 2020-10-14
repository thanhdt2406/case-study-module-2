package view.menu;

import model.User;

public class LoginMenu extends Menu {
    AdminMenu adminMenu = new AdminMenu();
    CustomerMenu customerMenu = new CustomerMenu();

    public void run() {
        String LOGIN_MENU = "|--1. Login-----|" +
                        "\n|--2. Sign up---|" +
                        "\n|--3. Exit------|";
        int choice;
        do {
            System.out.println("___________________________________________________");
            System.out.println(LOGIN_MENU);
            choice = inputer.inputInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 3:
                    System.out.println("Exit program!!!");
                    System.exit(0);
                default:
                    System.out.println("No choice! Try again :D");
            }
        } while (true);

    }

    public void login() {
        String username = inputer.inputAccount("Username: ");
        String password = inputer.inputAccount("Password: ");
        boolean loginSuccess = userManager.login(username, password);
        User currentUser = userManager.getCurrentUser();
        if (loginSuccess) {
            System.out.println("!~~_Login successful_~~!");
            if (currentUser.getRole()) {
                adminMenu.run();
            } else {
                customerMenu.run();
            }
        } else {
            System.out.println("Wrong username or password!");
            System.out.println("!~~_Login failed_~~!");
        }
    }


    public void signUp() {
        String username = inputer.inputAccount("Enter Username (5-30 characters): ");
        while (isExistUser(username)) {
            System.out.println("User already exists");
            username = inputer.inputString("Please enter another username: ");
        }
        String password = inputer.inputAccount("Enter Password (5-30 characters): ");
        String fullName = inputer.inputString("Enter your full name: ");
        int phoneNumber = inputer.inputPhoneNumber("Enter your phone number (0xxxxxxxxx): ");
        String address = inputer.inputString("Enter your address");
        User user = new User(username, password, fullName, phoneNumber, address);
        commander.chooseAddUser(user);
        System.out.println("!~~_Sign up successful_~~!");
    }

}
