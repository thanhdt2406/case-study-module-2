package manager;

import entity.User;

public interface IUserManager {
    boolean addUser();

    boolean updateUser();

    User deleteUser();

    void showAllUser();
}
