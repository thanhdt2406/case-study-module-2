package manager.user;

<<<<<<< HEAD

import java.util.HashMap;

public class UserManager implements IUserManager {
    HashMap listUser = new HashMap();
=======
import entity.User;
>>>>>>> 11245bfca3309f454cd00bd233d1203ccfe83d47

import java.util.HashMap;

public class UserManager implements IUserManager<User> {

    HashMap<String, User> userMap = new HashMap<>();
    @Override
<<<<<<< HEAD
    public boolean createUser() {

=======
    public boolean addUser(User user) {
        userMap.put(user.getUserName(), user);
>>>>>>> 11245bfca3309f454cd00bd233d1203ccfe83d47
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
