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

        sb.append("<html><body><h1>Liste des personnes</h1><ul>");
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
        sb.append("</ul>");

        sb.append("</body></html>");

        p.print(sb);
        p.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        super.doPost(req, resp);
    }
}
