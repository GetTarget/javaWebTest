<%@ page import="dhl.db.pojo.User" %>
<%@ page import="dhl.db.pojo.Goods" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dhl.db.service.GoodsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User loginUser = (User) session.getAttribute("authorization");
    if(loginUser == null)
    {
        response.sendRedirect(request.getContextPath()+"/login");
        return;
    }
    ArrayList<Goods> goodsList = GoodsService.SelectGoodsAll();
%>
<html>
<head>
    <style>
        #goodsTable {
            border: 1px;
            cellspacing: 0px;
        }
    </style>
    <title>商城主页</title>
</head>
<body>
    <%
        if(loginUser != null) {
    %>
        <h3>欢迎您，<%=loginUser.getUsername()%></h3>
    <%
        }
    %>
    <form id="goodsForm" action="${pageContext.request.contextPath}/AddGoodsServlet" method="post">
        <label for="goods_id">商品编号:</label><input id="goods_id" type="text" name="id" placeholder="商品编号">
        <label for="goods_name">商品名称:</label><input id="goods_name" type="text" name="name" placeholder="商品名称">
        <label for="goods_count">商品数量:</label><input id="goods_count" type="text" name="count" placeholder="商品数量">
        <label for="goods_price">商品价格:</label><input id="goods_price" type="text" name="price" placeholder="商品价格">
        <button id="submitButton" type="button">添加商品</button>
    </form>
    <h1>所有商品</h1>
    <table id="goodsTable">
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>库存数量</th>
            <th>商品价格</th>
        </tr>
        <%
            for (int i = 0; i<goodsList.size(); i++) {
        %>
        <tr>
            <td>
                <%=goodsList.get(i).getGoodsid()%>
            </td>
            <td>
                <%=goodsList.get(i).getGoodsname()%>
            </td>
            <td>
                <%=goodsList.get(i).getGoodscount()%>
            </td>
            <td>
                <%=goodsList.get(i).getGoodsprice()%>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/RemoveGoodsServlet/<%=goodsList.get(i).getGoodsid()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <script>
        var idReg = /^\d+$/;
        var nameReg = /^\w+$/;
        var countReg =/^\d+$/;
        var priceReg = /^\d+.?\d{0,2}$/

        var idInput = document.getElementById("goods_id");
        var nameInput = document.getElementById("goods_name");
        var countInput = document.getElementById("goods_count");
        var priceInput = document.getElementById("goods_price");
        var goodsForm = document.getElementById("goodsForm");
        var submitButton = document.getElementById("submitButton");

        submitButton.onclick = function () {
            var id = idInput.value.trim();
            var idRegResult = idReg.test(id);
            var name = nameInput.value.trim();
            var nameRegResult = nameReg.test(name);
            var count = countInput.value.trim();
            var countRegResult = countReg.test(count);
            var price = priceInput.value.trim();
            var priceRegResult = priceReg.test(price);

            if(idRegResult && nameRegResult && countRegResult && priceRegResult)
            {
                goodsForm.submit();
            }
            else
            {
                alert("商品信息输入格式不正确，请重新检查");
            }
        }
    </script>
</body>
</html>
