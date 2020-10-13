package controller.productCommander.userAcount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;
import model.user.User;

import java.util.List;

public class AddUser implements Command<List,User> {
    UserManager manager = UserManager.getUserManager();

    public AddUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public List excuse(User user) {
        manager.addUser(user);
        return null;
    }
}
