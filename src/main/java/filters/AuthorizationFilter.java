package filters;

import dao.LoginDAO;
import entity.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter for restricting access to menu and table for users who did not log in
 */
@WebFilter(urlPatterns = {"/menu", "/table"})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (LoginDAO.validate(user)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getServletContext().getRequestDispatcher("/jsp/noAccess.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
