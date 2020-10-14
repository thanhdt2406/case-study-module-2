package controller.productCommander.userAccount;

import controller.manager.user.UserManager;
import controller.productCommander.Command;

public class DeleteUser implements Command<Object,String> {
    UserManager manager = UserManager.getUserManager();

    public DeleteUser(UserManager manager) {
        this.manager = manager;
    }

    @Override
    public Object excuse(String username) {
        manager.deleteUser(username);
        return null;
    }
}
