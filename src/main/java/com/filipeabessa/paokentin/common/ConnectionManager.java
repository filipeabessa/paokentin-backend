package com.filipeabessa.paokentin.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
public class ConnectionManager {
    private static ConnectionManager connectionManager = null;

    private static final String URL = "jdbc:mysql://localhost:3306/paokentin";

    private static final String USER = "root";

    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getCurrentConnection() throws SQLException {

        if (connectionManager == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    static Connection getNewConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
