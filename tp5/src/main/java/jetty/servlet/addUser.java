package jetty.servlet;

import jetty.model.User;
import jetty.model.dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDao.addUser(new User(UserDao.getLastId() + 1, request.getParameter("name")));
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/kanban"));
    }
}
