package com.team2.bioskop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection connectToDb() throws SQLException {
        final String JDBC_URL = "jdbc:postgresql://localhost:5432/db-bioskop";
        final String USERNAME = System.getenv("DB_USER");
        final String PASSWORD = System.getenv("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            if(conn != null){
                System.out.println("Connect Success");
            }else{
                System.out.println("Connect Failed");
            }
            return conn;
    }
}
