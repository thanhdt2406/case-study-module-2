package controller.productCommander.userAccount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;
import model.User;

public class UpdateUser implements Command<Object,User> {
    UserManager manager = UserManager.getUserManager();

    public UpdateUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public Object excuse(User user) {
        manager.editUser(user);
        return null;
    }
}
