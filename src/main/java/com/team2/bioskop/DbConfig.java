package com.team2.bioskop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static Connection connect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/ticket_db2";
            return DriverManager.getConnection(url, "postgres","iqbal088");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
