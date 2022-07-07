package ni.org.ics.zpo.v2.utils;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("zikazpov2");
        dataSource.setPassword("jiKAQude");
        //dataSource.setPassword("123456");
        //dataSource.setServerName("141.211.217.99");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("zika_zpo_v2");
        dataSource.setUseSSL(false);
        dataSource.setCharacterEncoding("UTF-8");
        dataSource.setServerTimezone("UTC");

        return dataSource.getConnection();
    }
}
