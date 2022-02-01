package model.dao;

import model.Card;
import model.Kanban;
import model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static model.dao.ConnectionDB.fermerConnexionBd;

public class CardDao {
    public static List<Card> getCardByKanban(Kanban kanban) {
        List<Card> cards = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from card where kanban_id = '" + kanban.getId() + "'");
        try {
            while (reqSelection.next())
                cards.add(new Card(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3),
                        reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6),
                        reqSelection.getString(7), reqSelection.getString(8), reqSelection.getInt(9),
                        reqSelection.getInt(10)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from card where kanban_id = '" + kanban.getId() + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return cards;
    }

    public static List<Card> getCardForUser(User user) {
        List<Card> cards = new ArrayList<>();
        ResultSet reqSelection = ConnectionDB.execReqSelection("select * from card where user_id = '" + user.getId() + "'");
        try {
            while (reqSelection.next())
                cards.add(new Card(reqSelection.getInt(1), reqSelection.getString(2), reqSelection.getInt(3),
                        reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6),
                        reqSelection.getString(7), reqSelection.getString(8), reqSelection.getInt(9),
                        reqSelection.getInt(10)));
        } catch (Exception e) {
            System.out.println("erreur req - select * from card where user_id = '" + user.getId() + "'");
            e.printStackTrace();
        }
        fermerConnexionBd();
        return cards;
    }
}
