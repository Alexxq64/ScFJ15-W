package service;

import model.Home;
import model.User;

import java.util.TreeMap;

public class UserHomeService {
    public TreeMap<User, Home> data = new TreeMap<>();
    {
        UserService userService = UserService.getInstance();
        for (User user : userService.getData()) {
            data.put(user, new Home(user.getName() + " street"));
        }
    }
}
