package com.team2.bioskop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
public class SeatService {
    public static HashMap<String, Object> addSeat(int id, String seatNumber, int theaterId) {
        HashMap<String, Object> seat;
        try {
            var conn = DbConfig.connect();
            seat = new HashMap<>();

            String query = """
                    INSERT INTO m_seat (id, seat_number, theater_id)
                    VALUES (?, ?, ?);
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1,id);
            pr.setString(2, seatNumber);
            pr.setInt(3, theaterId);
            pr.executeUpdate();

            seat.put("id", id);
            seat.put("seat_number", seatNumber);
            seat.put("theater_id", theaterId);

            conn.close();
            return seat;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAll() {
        try {
            var conn = DbConfig.connect();
            String query = """
                    SELECT * FROM m_seat;
                    """;

            PreparedStatement pr = conn.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            var meta = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
            }
            pr.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static HashMap<String, Object> readOne(int id) {
        HashMap<String, Object> seat;
        try {
            var conn = DbConfig.connect();
            seat = new HashMap<>();
            String query = """
                    SELECT * FROM m_seat WHERE id = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            var meta = rs.getMetaData();

            // seat.put()

            while (rs.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++) {

                }
            }

            pr.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
