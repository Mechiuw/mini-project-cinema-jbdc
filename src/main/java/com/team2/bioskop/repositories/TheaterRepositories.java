package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.util.DbConnector;

import java.sql.*;
import java.util.Scanner;

public class TheaterRepositories {
    public static Scanner input = new Scanner(System.in);

    public static Theater addDataWithID(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                    INSERT INTO t_theater (id, theater_number, stock, film_id)
                    VALUES (?, ?, ?, ?);
                    """;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, theater.getId());
            pstmt.setString(2, theater.getTheater_number());
            pstmt.setInt(3, theater.getStock());
            pstmt.setInt(4, theater.getFilm_id());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theater;
    }

    public static Theater addData(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                    INSERT INTO t_theater (theater_number, stock, film_id)
                    VALUES (?, ?, ?);
                    """;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, theater.getTheater_number());
            pstmt.setInt(2, theater.getStock());
            pstmt.setInt(3, theater.getFilm_id());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theater;
    }

    public static ResultSet readData() {
        ResultSet rs = null;
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                select * from t_theater t
                join t_film f on t.film_id = f.id;
                """;
            PreparedStatement pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    public static Theater readDataByTheaterNumber(String theaterNumber) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_theater WHERE theater_number = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, theaterNumber);
            ResultSet rs = pr.executeQuery();

            Theater theater = null;
            if (rs.next()) {
                theater = new Theater(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        Integer.parseInt(rs.getString(3)),
                        Integer.parseInt(rs.getString(4)));
            }

            pr.close();
            rs.close();
            conn.close();
            return theater;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Theater readDataById(int id) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_theater WHERE id = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            Theater theater = null;
            if (rs.next()) {
                theater = new Theater(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        Integer.parseInt(rs.getString(3)),
                        Integer.parseInt(rs.getString(4)));
            }

            pr.close();
            rs.close();
            conn.close();
            return theater;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readTheater(int filmId){
        ResultSet rs = null;
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                select t.theater_number, t.stock, f.price from t_theater t
                join t_film f on t.film_id = f.id
                where f.id = ?;
                """;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, filmId);
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for(int i = 1 ; i <= columnCount; i++){
                System.out.printf("|%-18s ", metaData.getColumnName(i));
            }

            System.out.print(" |\n");
            while (rs.next()) {
                System.out.printf("| %-18s", rs.getString("theater_number"));
                System.out.printf("| %-18s", rs.getString("stock"));
                System.out.printf("| %-18s |", rs.getString("price"));
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Theater updateData(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                    UPDATE t_theater SET stock=?, film_id=?
                    WHERE id=?;
                    """;
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, theater.getStock());
                pstmt.setInt(2, theater.getFilm_id());
                pstmt.setInt(3, theater.getId());
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Successfully update data");
                    System.out.println("for id -> " + theater.getId());
                    System.out.println("stock -> " + theater.getStock());
                    System.out.println("film_id -> " + theater.getFilm_id());
                } else {
                    System.out.println("No data found for update");
                }
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theater;
    }

    public static void deleteData(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = "DELETE FROM t_theater WHERE theater_number=?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, theater.getTheater_number());
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println();
                } else {
                    System.out.println("No data found for deletion");
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
