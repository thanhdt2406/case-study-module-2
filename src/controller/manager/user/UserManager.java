package controller.manager.user;

import controller.manager.product.ProductManager;
import controller.storage.IOFileManager;
import model.User;

import java.io.IOException;
import java.util.HashMap;

public class UserManager implements IUserManager {
    private HashMap<String, User> listUser = new HashMap<>();
    private User currentUser = new User();
    private static UserManager userManager = new UserManager();

    private UserManager() {
        System.out.println("creaadf");
        readData();
    }
    public static UserManager getUserManager(){
        if(userManager==null){
            userManager = new UserManager();
        }
        return userManager;
    }


    public boolean login(String username, String password){
        if (username.equals("admin") && password.equals("admin")){
            currentUser.setRole(User.ROLE_ADMIN);
            return true;
        }
        for (User ele : listUser.values()){
            if (ele.getUserName().equals(username) && ele.getPassword().equals(password)){
                currentUser = ele;
                System.out.println("login success!");
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void readData() {
        IOFileManager ioFileManager = IOFileManager.getInstance();
        if(ioFileManager.isEmpty("data/user.dat")){
            return;
        }
        try {
            listUser = ioFileManager.readData("data/user.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        IOFileManager ioFileManager = IOFileManager.getInstance();
        try {
            ioFileManager.writeData(listUser, "data/user.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        listUser.put(user.getUserName(), user);
        writeData();
    }

    @Override
    public void showAllUser() {
        System.out.println("manage show user");
        System.out.println("map"+listUser);
        for (User ele : listUser.values()){
            System.out.println(ele.toString());
        }
    }

    @Override
    public boolean deleteUser(String userName) {
        readData();
        if (listUser.containsKey(userName)) {
            listUser.remove(userName);
            writeData();
            return true;
        }
        return false;
    }

    @Override
    public boolean editUser(String userName, String password, String fullName, int phoneNumber, String address) {
        readData();
        if (listUser.containsKey(userName)) {
            User user = new User(userName, password, fullName, phoneNumber, address);
            listUser.replace(userName, user);
            return true;
        }
        return false;
    }

    public boolean editUserPassword(String userName, String password) {
        readData();
        if (listUser.containsKey(userName)) {
            listUser.get(userName).setPassword(password);
            return true;
        }
        return false;
    }

    public boolean editUserName(String userName, String fullName) {
        readData();
        if (listUser.containsKey(userName)) {
            listUser.get(userName).setFullName(fullName);
            return true;
        }
        return false;
    }

    public boolean editUserPhoneNumber(String userName, int phoneNumber) {
        readData();
        if (listUser.containsKey(userName)) {
            listUser.get(userName).setPhoneNumber(phoneNumber);
            return true;
        }
        return false;
    }

    public boolean editUserAddress(String userName, String address) {
        readData();
        if (listUser.containsKey(userName)) {
            listUser.get(userName).setAddress(address);
            return true;
        }
        return false;
    }
}