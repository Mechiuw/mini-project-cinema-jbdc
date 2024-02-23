package com.team2.bioskop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection connect_to_db() {
        String jdbcurl = "jdbc:postgresql://localhost:5432/";
        String user = System.getenv("DB_USERNAME");
        String pass = System.getenv("DB_PASS");
        String dbname = "db_bioskop";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcurl + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
