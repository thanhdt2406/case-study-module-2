package controller.manager.user;


public interface IUserManager<T>{
    boolean addUser(T t);

    void showAllUser();

    boolean deleteUser();

    boolean editUser();
}
