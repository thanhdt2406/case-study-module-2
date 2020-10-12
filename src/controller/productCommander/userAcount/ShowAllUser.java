package controller.productCommander.userAcount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;

import java.util.HashMap;

public class ShowAllUser implements Command {
    UserManager manager = new UserManager();

    public ShowAllUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public HashMap excuse(Object o) {
        manager.showAllUser();
        return null;
    }
}
