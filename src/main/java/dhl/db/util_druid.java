package dhl.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class util_druid {
    public static util_druid util_instance;
    private DataSource dataSource;

    static {
        util_instance = new util_druid();
    }

    private util_druid() {
        Properties prop = new Properties();
        try {
            InputStream propStream = util_druid.class.getResourceAsStream("/druid.properties");
            prop.load(propStream);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
