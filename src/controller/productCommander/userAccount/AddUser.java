package controller.productCommander.userAccount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;
import model.User;

import java.util.List;

public class AddUser implements Command<List,User> {
    UserManager manager;

    public AddUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public List excuse(User user) {
        manager.addUser(user);
        return null;
    }
}
