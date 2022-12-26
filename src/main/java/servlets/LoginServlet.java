package servlets;

import dao.LoginDAO;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (LoginDAO.validate(user)) {
            response.sendRedirect(request.getContextPath() + "/menu");
        } else {
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        if (LoginDAO.validate(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);
            response.sendRedirect(request.getContextPath() + "/menu");
        } else {
            //for "invalid login/password" message in .jsp file
            request.setAttribute("isInvalidLogin", true);
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
