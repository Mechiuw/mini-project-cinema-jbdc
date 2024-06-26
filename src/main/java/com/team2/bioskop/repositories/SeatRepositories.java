package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Seat;
import com.team2.bioskop.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeatRepositories {
    public static Seat addSeat(String seatNumber, int theaterId) {
        Seat seat;
        try {
            var conn = DbConnector.connectToDb();

            String query = """
                    INSERT INTO t_seat (seat_number, theater_id)
                    VALUES (?, ?);
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, seatNumber);
            pr.setInt(2, theaterId);
            pr.executeUpdate();

            seat = new Seat(seatNumber, theaterId);

            pr.close();
            conn.close();
            return seat;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Seat> readAll() {
        ArrayList<Seat> listSeat;
        try {

            listSeat = new ArrayList<>();
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_seat;
                    """;

            PreparedStatement pr = conn.prepareStatement(query);
            ResultSet rs = pr.executeQuery();
            var meta = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                Seat seat = new Seat(
                        rs.getString(1),
                        Integer.parseInt(rs.getString(3)));
                listSeat.add(seat);
                System.out.println();
            }
            pr.close();
            rs.close();
            conn.close();
            return listSeat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Seat> readAll(int theaterId) {
        ArrayList<Seat> listSeat;
        try {
            listSeat = new ArrayList<>();
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_seat WHERE theater_id = ?;
                    """;

            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, theaterId);
            ResultSet rs = pr.executeQuery();
            var meta = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                Seat seat = new Seat(
                        rs.getString(2),
                        Integer.parseInt(rs.getString(3)));
                listSeat.add(seat);
                System.out.println();
            }


            pr.close();
            rs.close();
            conn.close();
            return listSeat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Seat readOne(int id) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_seat WHERE id = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            Seat seat = null;
            if (rs.next()) {
                seat = new Seat(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        Integer.parseInt(rs.getString(3)));
            }

            pr.close();
            rs.close();
            conn.close();
            return seat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Seat readOne(String seatNumber) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT * FROM t_seat WHERE seat_number = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, seatNumber);
            ResultSet rs = pr.executeQuery();

            Seat seat = null;
            if (rs.next()) {
                seat = new Seat(
                        Integer.parseInt(rs.getString(1)),
                        rs.getString(2),
                        Integer.parseInt(rs.getString(3)));
            }

            pr.close();
            rs.close();
            conn.close();
            return seat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Seat update(int id, String seatNumber, int theaterId) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    UPDATE t_seat SET seat_number = ?, theater_id = ? WHERE id = ?; 
                    """;

            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, seatNumber);
            pr.setInt(2, theaterId);
            pr.setInt(3, id);

            pr.executeUpdate();
            Seat seat = new Seat(seatNumber, theaterId);

            pr.close();
            conn.close();
            return seat;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) {
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    DELETE FROM t_seat WHERE id = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.executeUpdate();
            pr.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteByTheaterNumber(String theaterNumber) {
        try {
            var conn = DbConnector.connectToDb();
            String query = "DELETE FROM t_seat WHERE seat_number LIKE ?";
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setString(1, "%" + theaterNumber + "%");
            pr.executeUpdate();
            pr.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

