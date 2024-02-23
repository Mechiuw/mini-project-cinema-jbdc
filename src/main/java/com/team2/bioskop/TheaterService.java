package com.team2.bioskop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TheaterService extends DbConnector{
    private static Scanner input = new Scanner(System.in);

    public static void addData() {
        PreparedStatement pstmt;
        try {
            System.out.println("Input Theater Number");
            String theater_number = input.nextLine();
            System.out.println("Input Stock");
            Integer stock = input.nextInt();
            System.out.println("Input Film ID");
            Integer film_id = input.nextInt();
            String query = """
                    INSERT INTO t_theater (theater_number, stock, film_id)
                    VALUES (?, ?, ?);
                    """;
            pstmt = connectToDb().prepareStatement(query);
            pstmt.setString(1, theater_number);
            pstmt.setInt(2, stock);
            pstmt.setInt(3, film_id);
            pstmt.executeUpdate();
            System.out.println("Successfully insert data");
            System.out.println("theater_number -> " + theater_number);
            System.out.println("stock -> " + stock);
            System.out.println("film_id -> " + film_id);
            pstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void readData() {
        PreparedStatement pstmt;
        ResultSet rs;
        try {
            String query = """
                    select * from t_theater t
                    join t_film f on t.film_id = f.id;
                    """;
            pstmt = connectToDb().prepareStatement(query);
            rs = pstmt.executeQuery();
            System.out.println("ID | Theater Number | Stock | Title     |");
            while (rs.next()) {
                System.out.print(rs.getString("id") + "  | ");
                System.out.print(rs.getString("theater_number") + "             | ");
                System.out.print(rs.getString("stock") + "   | ");
                System.out.println(rs.getString("title") + " | ");
            }
            pstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updateData(){
        PreparedStatement pstmt;
        try {
            System.out.println("Input Stock");
            Integer stock = input.nextInt();
            System.out.println("Input Film ID");
            Integer film_id = input.nextInt();
            System.out.println("Input ID to Update");
            Integer id = input.nextInt();
            String query = """
                    UPDATE t_theater SET stock=?, film_id=?
                    WHERE id=?;
                    """;
            pstmt = connectToDb().prepareStatement(query);
            pstmt.setInt(1, stock);
            pstmt.setInt(2, film_id);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Successfully update data");
            System.out.println("stock -> " + stock);
            System.out.println("film_id -> " + film_id);
            System.out.println("for id -> " + film_id);
            pstmt.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteData() {
        PreparedStatement pstmt;
        try {
            System.out.println("Input Theater Number to Delete");
            String theater_number = input.nextLine();
            String query = "DELETE FROM t_theater WHERE theater_number=?";
            pstmt = connectToDb().prepareStatement(query);
            pstmt.setString(1, theater_number);
            pstmt.executeUpdate();
            System.out.println("Succesfully delete data");
            pstmt.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
