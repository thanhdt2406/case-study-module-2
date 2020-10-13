package controller.manager.user;

import model.User;

import java.util.HashMap;

public class UserManager implements IUserManager<User> {
    private HashMap<String, User> listUser = new HashMap();
    private User currentUser = new User();

    public UserManager() {
    }

    public boolean login(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            currentUser.setRole(User.ROLE_ADMIN);
            return true;
        }
        for (User ele : listUser.values()){
            if (ele.getUserName().equals(username) && ele.getPassword() == password){
                currentUser = ele;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

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