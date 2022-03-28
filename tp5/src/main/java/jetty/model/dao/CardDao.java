package jetty.model.dao;

import jetty.model.Card;
import jetty.model.User;
import jetty.model.Kanban;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static jetty.model.dao.ConnectionDB.fermerConnexionBd;

public class CardDao {
    public static List<Card> getCardByKanban(Kanban kanban) {
        List<Card> cards = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from Card where kanban_id = '" + kanban.getId() + "'");
        try {
            while (reqSelection.next())
                cards.add(new Card(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3),
                        reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6),
                        reqSelection.getString(7), reqSelection.getString(8), reqSelection.getInt(9),
                        reqSelection.getInt(10)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from Card where kanban_id = '" + kanban.getId() + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return cards;
    }

    public static List<Card> getCardForUser(User user) {
        List<Card> cards = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from Card where user_id = '" + user.getId() + "'");
        try {
            while (reqSelection.next())
                cards.add(new Card(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3),
                        reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6),
                        reqSelection.getString(7), reqSelection.getString(8), reqSelection.getInt(9),
                        reqSelection.getInt(10)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from Card where user_id = '" + user.getId() + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return cards;
    }

    public static int getLastId() {
        ResultSet reqSelection = ConnectionDB.execReqSelection("select id from Card order by id desc limit 1");
        try {
            if (reqSelection.next()) return reqSelection.getInt(1);
        } catch (Exception e) {
            System.out.println("erreur req - select id from Card order by id desc limit 1");
            e.printStackTrace();
        }
        ConnectionDB.fermerConnexionBd();
        return 0;
    }

    public static void addCard(Card c) {
        ConnectionDB.execReqMaj("insert into Card values('" + c.getId() + "','" + c.getEnd() + "','" + c.getEstimated() + "','" +
                c.getName() + "','" + c.getNote() + "','" + c.getPlace() + "','" + c.getType() + "','" + c.getUrl() + "','" +
                c.getKanban_id() + "','" + c.getUser_id() + "')");
        ConnectionDB.fermerConnexionBd();
    }
}
