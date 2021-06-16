package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT exists users(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(20) NOT NULL," +
                " lastName VARCHAR(30) NOT NULL," +
                "age TINYINT UNSIGNED NOT NULL);";
        try {
            PreparedStatement ps = Util.getMySQLConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF exists users";
        try {
            PreparedStatement ps = Util.getMySQLConnection().prepareStatement(sql);
            ps.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users (name, lastName, age) VALUES (?,?,?);";
        try (Connection connection = Util.getMySQLConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = Util.getMySQLConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = Util.getMySQLConnection()) {
            Statement ps = connection.createStatement();
            connection.setAutoCommit(false);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                usersList.add(user);
                connection.commit();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users";
        try (Connection connection = Util.getMySQLConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
