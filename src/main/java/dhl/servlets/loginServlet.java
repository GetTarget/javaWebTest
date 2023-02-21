package dhl.servlets;

import dhl.db.pojo.User;
import dhl.db.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        try {
            User try_to_get_user = UsersService.SelectUserByUsernameAndPassword(account, password);
            if (try_to_get_user!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("authorization", try_to_get_user);
                response.sendRedirect(request.getContextPath()+"/");
            }
            else {
                response.sendRedirect(request.getContextPath()+"/loginFail");
            }
        } catch (SQLException e) {
            response.sendRedirect(request.getContextPath()+"/loginFail");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
