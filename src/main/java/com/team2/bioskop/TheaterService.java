package com.team2.bioskop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TheaterService {
    private String jdbcurl = "jdbc:postgresql://localhost:5432/";
    private String user = System.getenv("DB_USERNAME");
    private String pass = System.getenv("DB_PASS");
    private String dbname = "db_bioskop";
    static Connection conn = null;



//    public static void addData() {
//        try {
//            conn = DriverManager.getConnection(jdbcurl + dbname, user, pass);
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//    }
}
