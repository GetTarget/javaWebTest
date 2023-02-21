package dhl.servlets;

import dhl.db.pojo.Goods;
import dhl.db.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goods_id = request.getParameter("id");
        String goods_name = request.getParameter("name");
        int goods_count = Integer.parseInt(request.getParameter("count"));
        float goods_price = Float.parseFloat(request.getParameter("price"));

        Goods new_goods = new Goods(goods_id, goods_name, goods_count, goods_price);
        System.out.println(new_goods);
        GoodsService.AddGoods(new_goods);
        response.sendRedirect(request.getContextPath()+"/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
