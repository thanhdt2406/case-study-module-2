package controller.manager.user;

import controller.storage.IOFileManager;
import model.User;
import java.io.IOException;
import java.util.HashMap;

public class UserManager implements IUserManager {
    private HashMap<String, User> listUser = new HashMap<>();
    private User currentUser = new User();
    private static UserManager userManager = new UserManager();

    private UserManager() {
        readData();
    }

    public static UserManager getUserManager() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }


    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            currentUser.setRole(true);
            return true;
        }
        for (User user : listUser.values()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                currentUser.setRole(false);
                System.out.println("!~~_Login successful_~~!");
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
        if (ioFileManager.isEmpty("data/user.dat")) {
            return;
        }
        try {
            listUser = ioFileManager.readData("data/user.dat");
        } catch (ClassNotFoundException | IOException e) {
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

    public HashMap<String, User> getListUser() {
        return listUser;
    }

    @Override
    public void addUser(User user) {
        listUser.put(user.getUserName(), user);
        writeData();
    }

    @Override
    public void showAllUser() {
        if(listUser.isEmpty()){
            System.out.println("No customer account!");
            return;
        }
        for (User user : listUser.values()) {
            System.out.println(user.toString());
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
    public boolean editUser(User user) {
        readData();
        if (listUser.containsKey(user.getUserName())) {
            listUser.replace(user.getUserName(), user);
            return true;
        }
        return false;
    }
}