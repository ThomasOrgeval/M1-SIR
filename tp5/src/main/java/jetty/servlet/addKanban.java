package jetty.servlet;

import jetty.model.dao.KanbanDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addKanban", urlPatterns = {"/addKanban"})
public class addKanban extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        KanbanDao.addKanban(new jetty.model.Kanban(KanbanDao.getLastId() + 1, request.getParameter("kanban"), Integer.parseInt(request.getParameter("user"))));
    }
}
