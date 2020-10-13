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

    public void run(){
        int choice;
        do {
            System.out.println("___________________________________________________");
            System.out.println(LOGIN_MENU);
            choice = inputer.inputInt("enter your choice: ");
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                default:
                    System.out.println("choose an option");
            }
        }while (choice !=3);

    }

    public void login(){
        String username = inputer.inputString("Username: ");
        String password = inputer.inputString("Password: ");
        boolean loginSuccess = userManager.login(username, password);
        if (loginSuccess){
            System.out.println("login sucsses~!");
            if (userManager.getCurrentUser().getRole() == User.ROLE_ADMIN){
                System.out.println("admin");
                adminMenu.run();
            }else {
                System.out.println("customer");
                customerMenu.run();
            }
        }
    }

    public void signUp(){
        String username = inputer.inputString("Enter username: ");
        String password = inputer.inputString("Enter password: ");
        String fullName = inputer.inputString("Enter your full name: ");
        int phoneNumber = inputer.inputInt("Enter your phone number: ");
        String address = inputer.inputString("Enter your address");

        User user = new User(username,password,fullName,phoneNumber,address);
        comander.chooseAddUser(user);
    }
}
