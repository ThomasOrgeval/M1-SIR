package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDB {
    static Connection cnx;

    public ConnectionDB() {
        cnx = null;
    }

    public static void connecterBd() {
        String url = "jdbc:mysql://localhost:3306/sirtp2";
        try {
            cnx = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println("Echec lors de la connexion");
        }
    }

    public static ResultSet execReqSelection(String laRequete) {
        connecterBd();
        ResultSet resultatReq = null;
        try {
            Statement requete = cnx.createStatement();
            resultatReq = requete.executeQuery(laRequete);
        } catch (Exception e) {
            System.out.println("Erreur requete : " + laRequete);
        }
        return resultatReq;
    }

    public static int execReqMaj(String laRequete) {
        connecterBd();
        int nbMaj = 0;
        try {
            Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            nbMaj = s.executeUpdate(laRequete);
            s.close();
        } catch (Exception er) {
            er.printStackTrace();
            System.out.println("echec requ�te : " + laRequete);
        }
        return nbMaj;
    }

    public static void fermerConnexionBd() {
        try {
            cnx.close();
        } catch (Exception e) {
            System.out.println("Erreur sur fermeture connexion");
        }
    }

}
