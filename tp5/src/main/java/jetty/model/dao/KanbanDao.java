package jetty.model.dao;

import jetty.model.Kanban;
import jetty.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KanbanDao {
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
}
