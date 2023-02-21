package dhl.db.service;
import dhl.db.pojo.User;
import dhl.db.util_druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersService {
    public static User SelectUserByUsernameAndPassword(String username, String password) throws SQLException {
        Connection con = util_druid.util_instance.getConnection();
        String sql = "select * from users where username=? and password=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, username);
        stat.setString(2, password);
        ResultSet rs = stat.executeQuery();
        while (rs.next())
        {
            String db_mail = rs.getString("mail");
            String db_username = rs.getString("username");
            String db_password = rs.getString("password");
            int db_power = rs.getInt("power");
            if(db_username.equals(username))
            {
                return new User(db_mail, db_username, db_password, db_power);
            }
        }
        return null;
    }

    public static User SelectUserByUsername(String username) throws SQLException {
        Connection con = util_druid.util_instance.getConnection();
        String sql = "select * from users where username=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, username);
        ResultSet rs = stat.executeQuery();
        while (rs.next())
        {
            String db_mail = rs.getString("mail");
            String db_username = rs.getString("username");
            String db_password = rs.getString("password");
            int db_power = rs.getInt("power");
            if(db_username.equals(username))
            {
                return new User(db_mail, db_username, db_password, db_power);
            }
        }
        return null;
    }

    public static User SelectUserByMail(String mail) throws SQLException {
        Connection con = util_druid.util_instance.getConnection();
        String sql = "select * from users where username=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, mail);
        ResultSet rs = stat.executeQuery();
        while (rs.next())
        {
            String db_mail = rs.getString("mail");
            String db_username = rs.getString("username");
            String db_password = rs.getString("password");
            int db_power = rs.getInt("power");
            if(db_mail.equals(mail))
            {
                return new User(db_mail, db_username, db_password, db_power);
            }
        }
        return null;
    }

    public static boolean AddUser(User user){
        String sql = "insert into users values(?, ?, ?, ?)";
        try {
            Connection con = util_druid.util_instance.getConnection();
            if(con != null) {
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, user.getMail());
                stat.setString(2, user.getUsername());
                stat.setString(3, user.getPassword());
                stat.setInt(4, user.getPower());
                int count = stat.executeUpdate();
                con.close();
                if (count == 0) {
                    return false;
                } else {
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

    public static boolean RemoveUserByUsername(String username) {
        try {
            Connection con = util_druid.util_instance.getConnection();
            if(con != null) {
                String sql = "delete from users where username = ?";
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, username);
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

    public static boolean RemoveUserByMail(String mail) {
        try {
            Connection con = util_druid.util_instance.getConnection();
            if(con != null) {
                String sql = "delete from users where mail = ?";
                PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1, mail);
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
