package controller.manager.user;

import controller.manager.IManager;

public interface IUserManager<T> extends IManager {
    boolean addUser(T t);

    void showAllUser();

    boolean deleteUser();

    boolean editUser();
}
