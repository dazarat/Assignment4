package dao;

import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for imitation DB
 */
public class LoginDAO {

    private static final List<User> userList;

    public static List<User> getUserList() {
        return userList;
    }

    public static boolean validate(User user){
        return userList.contains(user);
    }

    static {
        userList = new ArrayList<>();
        userList.add(new User("admin", "123", "Administrator Ivan"));
        userList.add(new User("alex_best", "pass1", "Alexey Ivanov"));
        userList.add(new User("borya777", "securepass1234", "Boris Demyanov"));
    }
}
