package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Properties props = new Properties();

        // Load properties file
        FileInputStream fis = new FileInputStream("src/db.properties");
        props.load(fis);

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}