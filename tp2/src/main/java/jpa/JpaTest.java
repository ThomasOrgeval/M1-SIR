package jpa;

import jpa.object.Card;
import jpa.object.CardType;
import jpa.object.Kanban;
import jpa.object.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
    private final EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        JpaTest test = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createKanban();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();


        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    private void createKanban() {
        if (manager.createQuery("Select a From User a", User.class).getResultList().size() == 0) {
            User user = new User("Orgeval");
            manager.persist(user);
            Kanban kanban = new Kanban(user, "monKanban");
            Card card1 = new Card(CardType.DONE, "tp 2");
            kanban.addCard(card1);
            Card card2 = new Card(CardType.TODO, "tp 10");
            card2.setUser(user);
            kanban.addCard(card2);

            manager.persist(kanban);
            manager.persist(card1);
            manager.persist(card2);
        }

    }
}
