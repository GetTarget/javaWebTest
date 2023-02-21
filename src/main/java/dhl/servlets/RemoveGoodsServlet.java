package dhl.servlets;

import dhl.db.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveGoodsServlet", value = "/RemoveGoodsServlet/*")
public class RemoveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getRequestURI();
        goods_id = goods_id.substring(goods_id.lastIndexOf("/")+1);
        GoodsService.RemoveGoodsByGoodsid(goods_id);
        response.sendRedirect(request.getContextPath()+"/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
