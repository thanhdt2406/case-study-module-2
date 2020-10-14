package controller.manager.user;


import model.User;

public interface IUserManager{
    void addUser(User user);

    void showAllUser();

    boolean deleteUser(String userName);

    boolean editUser(User user);
}
