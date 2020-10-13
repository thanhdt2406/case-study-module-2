package controller.productCommander.userAcount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;
import model.Product;
import model.User;

import java.util.List;

public class AddUser implements Command<User> {
    UserManager manager = new UserManager();

    public AddUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Product> excuse(User user) {
        manager.addUser(user);
        return null;
    }
}
