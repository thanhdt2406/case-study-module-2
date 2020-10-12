package controller.productCommander;

import controller.manager.user.UserManager;

public class ShowAllUser implements Command {
    UserManager manager = new UserManager();

    public ShowAllUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public void excuse(Object o) {
        manager.showAllUser();
    }
}
