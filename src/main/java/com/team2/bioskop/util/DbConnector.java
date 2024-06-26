package com.team2.bioskop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection connect;
    public static Connection connectToDb() throws SQLException {
        final String JDBC_URL = "jdbc:postgresql://localhost:5432/db_bioskop";
        final String USERNAME = System.getenv("DB_USER");
        final String PASSWORD = System.getenv("DB_PASSWORD");
        connect = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            if(connect == null){
                System.out.println("Connect Failed");
            }

            return connect;
    }
}
