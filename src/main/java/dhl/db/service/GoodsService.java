package dhl.db.service;

import dhl.db.pojo.Goods;
import dhl.db.util_druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsService {
    public static ArrayList<Goods> SelectGoodsAll() throws SQLException {
        Connection con = util_druid.util_instance.getConnection();
        if(con != null) {
            String sql = "select * from goods";
            PreparedStatement stat = con.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            ArrayList<Goods> goodsList = new ArrayList<Goods>();
            while (rs.next()) {
                String db_goodsid = rs.getString("goodsid");
                String db_goodsname = rs.getString("goodsname");
                int db_goodscount = rs.getInt("goodscount");
                float db_goodsprice = rs.getFloat("goodsprice");
                goodsList.add(new Goods(db_goodsid, db_goodsname, db_goodscount, db_goodsprice));
            }
            con.close();
            return goodsList;
        }
        else {
            return new ArrayList<Goods>();
        }
    }

    public static Goods SelectGoodsByGoodsid(String goodsid) throws SQLException {
        Connection con = util_druid.util_instance.getConnection();
        if(con != null) {
            String sql = "select * from goods where goodsid=?";
            PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, goodsid);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                String db_goodsid = rs.getString("goodsid");
                String db_goodsname = rs.getString("goodsname");
                int db_goodscount = rs.getInt("goodscount");
                float db_goodsprice = rs.getFloat("goodsprice");
                if (db_goodsid.equals(goodsid)) {
                    return new Goods(goodsid, db_goodsname, db_goodscount, db_goodsprice);
                }
            }
            con.close();
            return null;
        }
        else {
            return null;
        }
    }

    public static boolean AddGoods(Goods goods) {
        String sql = "insert into goods values(?, ?, ?, ?)";
        try {
            Connection con = util_druid.util_instance.getConnection();
            if(con != null) {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, goods.getGoodsid());
                stat.setString(2, goods.getGoodsname());
                stat.setInt(3, goods.getGoodscount());
                stat.setFloat(4, goods.getGoodsprice());
                int count = stat.executeUpdate();
                con.close();
                if(count == 0) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean RemoveGoodsByGoodsid(String goodsid){
        String sql = "delete from goods where goodsid = ?";
        try {
            Connection con = util_druid.util_instance.getConnection();
            if(con != null) {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, goodsid);
                int count = stat.executeUpdate();
                con.close();
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
