package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        // create table users
        service.createUsersTable();

        User user1 = new User("Ivan", "Ivanov", (byte) 18);
        User user2 = new User("Petr", "Petrov", (byte) 20);
        User user3 = new User("Masha", "Mashkova", (byte) 21);
        User user4 = new User("Fedor", "Fedorov", (byte) 24);
        // save user
        service.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем " + user1.getName() + " добавлен в базу данных.");
        service.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем " + user2.getName() + " добавлен в базу данных.");
        service.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем " + user3.getName() + " добавлен в базу данных.");
        service.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем " + user4.getName() + " добавлен в базу данных.");

        // get all users
        for (int i = 0; i < service.getAllUsers().size(); i++) {
            System.out.println(service.getAllUsers().get(i));
        }

        // clean table users
        service.cleanUsersTable();

        // drop table
        service.dropUsersTable();
    }
}
