package controller.manager.user;

import model.User;

import java.util.HashMap;

public class UserManager implements IUserManager<User> {
    HashMap<String, User> listUser = new HashMap();

    @Override
    public boolean addUser(User user) {
        listUser.put(user.getUserName(),user);
        return false;
    }

    @Override
    public void showAllUser() {
        for (User ele : listUser.values()){
            System.out.println(ele.toString());
        }
    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public boolean editUser() {
        return false;
    }
}