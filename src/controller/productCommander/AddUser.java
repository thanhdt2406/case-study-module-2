package controller.productCommander;

import controller.manager.user.UserManager;
import model.User;

public class AddUser implements Command<User> {
    UserManager manager = new UserManager();

    public AddUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public void excuse(User user) {
        manager.addUser(user);
    }
}
