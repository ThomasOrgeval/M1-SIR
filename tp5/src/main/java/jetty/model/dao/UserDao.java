package jetty.model.dao;

import jetty.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static jetty.model.dao.ConnectionDB.fermerConnexionBd;

public class UserDao {
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from user");
        try {
            while (reqSelection.next())
                users.add(new User(reqSelection.getInt(1), reqSelection.getString(2)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from user");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return users;
    }

    public static User getUser(int id) {
        User user = null;
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from user where id='" + id + "'");
        try {
            if (reqSelection.next())
                user = new User(reqSelection.getInt(1), reqSelection.getString(2));
        } catch (Exception e) {
            System.out.println("erreur req - select * from user where id='" + id + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return user;
    }

    public static User getUserByName(String name) {
        User user = null;
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from user where name like '" + name + "'");
        try {
            if (reqSelection.next())
                user = new User(reqSelection.getInt(1), reqSelection.getString(2));
        } catch (Exception e) {
            System.out.println("erreur req - select * from user where name like '" + name + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return user;
    }
}
