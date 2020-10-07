package manager;

import entity.User;

public interface IUserManager {
    boolean createUser();

    boolean updateUser();

    User deleteUser();

    void showAllUser();
}
