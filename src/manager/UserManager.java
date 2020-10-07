package manager;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserManager implements IUserManager{
    private HashMap userMap = new HashMap();

    @Override
    public boolean createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("");
    }

    @Override
    public boolean updateUser() {
        return false;
    }

    @Override
    public User deleteUser() {
        return null;
    }

    @Override
    public void showAllUser() {

    }
}
