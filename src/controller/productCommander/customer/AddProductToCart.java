package controller.productCommander.customer;

import controller.productCommander.Command;
import model.user.User;

public class AddProductToCart implements Command {
    User user = new User();
    @Override
    public Object excuse(Object o) {
        return null;
    }
}
