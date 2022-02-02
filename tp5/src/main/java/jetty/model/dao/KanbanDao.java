package jetty.model.dao;

import jetty.model.Kanban;
import jetty.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KanbanDao {
    public static List<Kanban> getKanbans() {
        List<Kanban> kanbans = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from kanban");
        try {
            while (reqSelection.next())
                kanbans.add(new Kanban(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from kanban");
            e.printStackTrace();
        }
        ConnectionDB.fermerConnexionBd();
        return kanbans;
    }

    public static List<Kanban> getKanbanForOwner(User user) {
        List<Kanban> kanbans = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from kanban where owner_id = '" + user.getId() + "'");
        try {
            while (reqSelection.next())
                kanbans.add(new Kanban(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from kanban where owner_id = '" + user.getId() + "'");
            e.printStackTrace();
        }
        ConnectionDB.fermerConnexionBd();
        return kanbans;
    }

    public static Kanban getKanban(String name) {
        Kanban kanban = null;
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from kanban where kanban like '" + name + "'");
        try {
            if (reqSelection.next())
                kanban = new Kanban(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3));
        } catch (Exception e) {
            System.out.println("erreur req - select * from kanban where kanban like '" + name + "'");
            e.printStackTrace();
        }
        ConnectionDB.fermerConnexionBd();
        return kanban;
    }

    public static int getLastId() {
        ResultSet reqSelection = ConnectionDB.execReqSelection("select id from kanban order by id desc limit 1");
        try {
            if (reqSelection.next()) return reqSelection.getInt(1);
        } catch (Exception e) {
            System.out.println("erreur req - select id from kanban order by id desc limit 1");
            e.printStackTrace();
        }
        ConnectionDB.fermerConnexionBd();
        return 0;
    }

    public static void addKanban(Kanban kanban) {
        ConnectionDB.execReqMaj("insert into kanban values('" + kanban.getId() + "','" + kanban.getKanban() + "','" + kanban.getOwner_id() + "')");
        ConnectionDB.fermerConnexionBd();
    }
}
