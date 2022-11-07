package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("K", "S", (byte) 33);
        userService.saveUser("T", "S", (byte) 25);
        userService.saveUser("P", "I", (byte) 48);
        userService.saveUser("J", "S", (byte) 52);
        System.out.println(userService.getAllUsers());
//        userService.removeUserById(2);
//        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
