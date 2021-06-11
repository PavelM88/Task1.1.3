package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDaoJDBCImpl userJDBS = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userJDBS.createUsersTable();
    }

    public void dropUsersTable() {
        userJDBS.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userJDBS.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userJDBS.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userJDBS.getAllUsers();
    }

    public void cleanUsersTable() {
        userJDBS.cleanUsersTable();
    }
}
