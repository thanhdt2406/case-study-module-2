package controller.manager.user;

import controller.manager.ISearcher;

public interface IUserManager<T> extends ISearcher {
    boolean addUser(T t);

    void showAllUser();

    boolean deleteUser();

    boolean editUser();
}
