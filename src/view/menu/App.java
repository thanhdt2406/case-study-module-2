package view.menu;

import controller.io.Inputer;
import controller.manager.user.UserManager;
import model.User;

public class App {
    AdminMenu adminMenu = new AdminMenu();
    CustomerMenu customerMenu = new CustomerMenu();

    UserManager userManager = new UserManager();
    User currenUser = new User();

    Inputer inputer = new Inputer();
    public void login(){
        String username = inputer.inputString("Username: ");
        String password = inputer.inputString("Password: ");
        boolean loginSuccess = userManager.login(username, password);
        if (loginSuccess){
            if (userManager.getCurrentUser().getRole() == User.ROLE_ADMIN){
                adminMenu.run();
            }else {
                customerMenu.run();
            }
        }

    }
}
