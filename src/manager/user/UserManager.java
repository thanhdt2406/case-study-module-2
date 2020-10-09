package manager.user;

import entity.User;

import java.util.HashMap;

public class UserManager implements IUserManager<User> {

    HashMap<String, User> userMap = new HashMap<>();
    @Override
    public boolean addUser(User user) {
        userMap.put(user.getUserName(), user);
        return false;
    }

    @Override
    public void showAllUser(){
        for (User ele : userMap.values()){
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
