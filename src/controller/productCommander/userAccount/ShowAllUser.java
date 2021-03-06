package controller.productCommander.userAccount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;
import model.Product;

import java.util.List;

public class ShowAllUser implements Command {
    UserManager manager;

    public ShowAllUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Product> excuse(Object o) {
        manager.showAllUser();
        return null;
    }
}
