package manager.user;

import manager.IManager;

public interface IUserManager extends IManager {
    boolean createUser();

    void showAllUser();

    boolean deleteUser();

    boolean editUser();
}
