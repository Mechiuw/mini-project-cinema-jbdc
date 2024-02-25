package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Seat;
import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TheaterRepositories {
    public static Scanner input = new Scanner(System.in);

    public static Theater addData(Theater theater) {
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



    public static Theater updateData(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = """
                    UPDATE t_theater SET stock=?, film_id=?
                    WHERE id=?;
                    """;
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, theater.getStock());
            pstmt.setInt(2, theater.getFilm_id());
            pstmt.setInt(3, theater.getId());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return theater;
    }

    public static void deleteData(Theater theater) {
        try (Connection conn = DbConnector.connectToDb()) {
            String query = "DELETE FROM t_theater WHERE theater_number=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, theater.getTheater_number());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
