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

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("email");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = new User(mail,account,password,0);
        if (UsersService.AddUser(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("authorization", user);
            response.sendRedirect(request.getContextPath()+"/");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/registerFail");
            System.out.println("注册失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
