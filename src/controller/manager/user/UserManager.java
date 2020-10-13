package controller.manager.user;

import controller.storage.IOFileManager;
import model.User;

import java.io.IOException;
import java.util.HashMap;

public class UserManager implements IUserManager<User> {
    private HashMap<String, User> listUser;
    private User currentUser = new User();

    public UserManager() {
        listUser = new HashMap<>();
    }

    public boolean login(String username, String password){
        readData();
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

    private void readData(){
        IOFileManager ioFileManager = new IOFileManager();
        try {
            listUser = ioFileManager.readData("data/user.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeData(){
        IOFileManager ioFileManager = new IOFileManager();
        try {
            ioFileManager.writeData(listUser,"data/user.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addUser(User user) {
        listUser.put(user.getUserName(),user);
        writeData();
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