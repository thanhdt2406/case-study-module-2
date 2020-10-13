package view.menu;

import controller.io.Inputer;
import controller.manager.user.UserManager;
import model.User;
import view.menu.AdminMenu;
import view.menu.CustomerMenu;

public class LoginMenu extends Menu {
    private final String LOGIN_MENU = "|-- 1. Login----|" +
            "|-- 2. Sign up--|" +
            "|--3. Exit------|";
    AdminMenu adminMenu = new AdminMenu();
    CustomerMenu customerMenu = new CustomerMenu();

    public void run() {
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
                    System.out.println("Choose an option");
            }
        } while (true);

    }

    public void login() {
        String username = inputer.inputString("Username: ");
        String password = inputer.inputString("Password: ");
        boolean loginSuccess = userManager.login(username, password);
        if (loginSuccess) {
            System.out.println("!~~_Login successful_~~!");
            if (userManager.getCurrentUser().getRole() == User.ROLE_ADMIN) {
                adminMenu.run();
            } else {
                customerMenu.run();
            }
        }
    }

    private boolean isExistUser(String userName) {
        UserManager userManager = UserManager.getUserManager();
        if (userManager.getListUser().containsKey(userName)||userName.equals("admin")) {
            return true;
        }
        return false;
    }

    public void signUp() {
        String username = inputer.inputString("Enter Username: ");
        while (isExistUser(username)) {
            System.out.println("User already exists");
            username = inputer.inputString("Please enter another username: ");
        }
        String password = inputer.inputString("Enter Password: ");
        String fullName = inputer.inputString("Enter your full name: ");
        int phoneNumber = inputer.inputInt("Enter your phone number: ");
        String address = inputer.inputString("Enter your address");
        User user = new User(username, password, fullName, phoneNumber, address);
        comander.chooseAddUser(user);
        System.out.println("!~~_Sign up successful_~~!");
    }


}
