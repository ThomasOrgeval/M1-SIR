package jetty.servlet;

import jetty.model.Card;
import jetty.model.dao.CardDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCard", urlPatterns = {"/addCard"})
public class addCard extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CardDao.addCard(new Card(CardDao.getLastId() + 1, request.getParameter("end"), Integer.parseInt(request.getParameter("estimated")),
                request.getParameter("name"), request.getParameter("note"), request.getParameter("place"), request.getParameter("type"),
                request.getParameter("url"), Integer.parseInt(request.getParameter("user")), Integer.parseInt(request.getParameter("kanban"))));
    }
}
