package jetty.servlet;

import jetty.model.Card;
import jetty.model.User;
import jetty.model.dao.CardDao;
import jetty.model.dao.KanbanDao;
import jetty.model.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "kanban", urlPatterns = {"/kanban"})
public class Kanban extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder();
        List<User> users = UserDao.getUsers();

        sb.append("<html><body><h1>Liste des <a href='./user'>personnes</a> -> kanbans -> <a href='./card'>cards</a></h1><ul>");
        for (User user : users) {
            sb.append("<li>").append(user.getId()).append(": ").append(user.getName()).append("</li><ul>");
            for (jetty.model.Kanban kanban : KanbanDao.getKanbanForOwner(user)) {
                sb.append("<li>").append(kanban.getId()).append(": ").append(kanban.getKanban()).append("</li><ul>");
                for (Card card : CardDao.getCardByKanban(kanban)) {
                    sb.append("<li>").append(card.getId()).append(": ").append(card.getName()).append(" -> ").append(card.getType()).append("</li>");
                }
                sb.append("</ul>");
            }
            sb.append("</ul>");
        }

        sb.append("</ul><h2>Ajouter une personne</h2><form method='post' action='./addUser'>");
        sb.append("Prenom et nom : <input type='text' size='20' name='name' required/><br>");
        sb.append("<button type=submit>Envoyer</button>");

        sb.append("</form><h2>Ajouter un kanban</h2><form method='post' action='./addKanban'>");
        sb.append("Kanban : <input type='text' size='20' name='kanban' required/><br>");
        sb.append("Createur : <select name=user required>");
        for (User user : users) sb.append("<option value=").append(user.getId()).append(">").append(user.getName()).append("</option>");
        sb.append("</select><br>");
        sb.append("<button type=submit>Envoyer</button>");

        sb.append("</form><h2>Ajouter une card</h2><form method='post' action='./addCard'>");
        sb.append("Nom : <input name=name type=text required/><br>");
        sb.append("Date de fin : <input name=end type='date'/><br>");
        sb.append("Temps estime : <input name=estimated type=number /> (en minutes)<br>");
        sb.append("Lieu : <input name=place type=text /><br>");
        sb.append("Status : <select name=type required><option value=TODO>TODO</option><option value=DOING>DOING</option><option value=DONE>DONE</option></select><br>");
        sb.append("URL : <input name=url type=text /><br>");
        sb.append("Notes : <input name=note type=text /><br>");
        sb.append("Assigner a : <select name=user><option value=''>...</option>");
        for (User user : users) sb.append("<option value=").append(user.getId()).append(">").append(user.getName()).append("</option>");
        sb.append("</select><br>");
        sb.append("Kanban : <select name=kanban required>");
        for (jetty.model.Kanban kanban : KanbanDao.getKanbans()) sb.append("<option value=").append(kanban.getId()).append(">").append(kanban.getKanban()).append("</option>");
        sb.append("</select><br>");
        sb.append("<button type=submit>Envoyer</button>");

        sb.append("</form></body></html>");

        p.print(sb);
        p.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        super.doPost(req, resp);
    }
}
