package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Seat;
import com.team2.bioskop.entity.Ticket;
import com.team2.bioskop.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TicketRepositories {
    public static void insert(Ticket ticket, String customerName, String seatId){
        try(Connection connection = DbConnector.connectToDb()){
            connection.setAutoCommit(false);


            String sqlCustomer = """
                    SELECT id FROM m_customer WHERE name = ?;
                    """;

            PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlCustomer);
            preparedStatementSelect.setString(1, customerName);
            ResultSet resultSet = preparedStatementSelect.executeQuery();
            int result = 0;
            if(resultSet.next()){
                result = resultSet.getInt("id");
            }

            String sqlSeat = """
                    SELECT id FROM t_seat WHERE seat_number = ?;
                    """;

            PreparedStatement preparedStatementSeat = connection.prepareStatement(sqlSeat);
            preparedStatementSeat.setString(1, seatId);
            ResultSet resultSet1 = preparedStatementSeat.executeQuery();
            int result1 = 0;
            if(resultSet1.next()){
                result1 = resultSet1.getInt("id");
            }

            String sql = """
                    INSERT INTO trx_ticket (customer_id, seat_id) VALUES
                    (?, ?);
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, result);
            preparedStatement.setInt(2, result1);
            preparedStatement.executeUpdate();
            ticket.setCustomer_id(result);
            ticket.setSeat_id(result1);

            String sqlUpdate = """
                    UPDATE t_theater 
                    SET stock = stock - 1 
                    WHERE id = (
                        SELECT theater_id 
                        FROM t_seat
                        WHERE id =? );
                    """;
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setInt(1, ticket.getSeat_id());
            preparedStatementUpdate.executeUpdate();

            preparedStatementUpdate.close();
            preparedStatementSeat.close();
            preparedStatementSelect.close();
            preparedStatement.close();
            connection.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    public static List<Seat> getSeat(String theaterName){
        try(Connection connection = DbConnector.connectToDb()){
            List <Seat> seats = new ArrayList<>() ;
            String sql = """
                    Select t.seat_number, h.theater_number
                    FROM t_seat t
                        JOIN
                        t_theater h ON h.id = t.theater_id
                        JOIN
                    	t_film f ON f.id = h.film_id
                    	WHERE h.theater_number = ? AND f.id = h.film_id
                    GROUP BY t.id, t.seat_number, h.theater_number
                    ORDER BY t.id;
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, theaterName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){;
                String seatNumber = resultSet.getString("seat_number");
                String theaterNumber = resultSet.getString("theater_number");
                Seat seat = new Seat();
                seat.setSeatNumber(seatNumber);
                seat.setTheaterNumber(theaterNumber);
                seats.add(seat);
            }
            statement.close();
            return seats;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Ticket> getSeatTicket(String theaterName){
        try(Connection connection = DbConnector.connectToDb()){
            List <Ticket> ticketSeats = new ArrayList<>() ;
            String sql = """
                    Select s.seat_number, h.theater_number
                    FROM trx_ticket t
                        JOIN
                        t_seat s ON s.id = t.seat_id
                        JOIN
                        t_theater h ON h.id = s.theater_id
                        JOIN
                    	t_film f ON f.id = h.film_id
                    	WHERE t.seat_id = s.id AND h.theater_number = ?
                    GROUP BY t.id, s.seat_number, h.theater_number
                    ORDER BY t.id ASC;
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, theaterName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){;
                String seatNumber = resultSet.getString("seat_number");
                String theaterNumber = resultSet.getString("theater_number");
                Ticket ticket = new Ticket();
                ticket.setSeatNumber(seatNumber);
                ticket.setTheaterNumber(theaterNumber);
                ticketSeats.add(ticket);
            }
            statement.close();
            return ticketSeats;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void showTicketAvailable(String theaterName){
        List<Seat> seats = getSeat(theaterName);
        List<Ticket> tickets = getSeatTicket(theaterName);

        Set<String> bookedSeats = new HashSet<>();
        int counter = 0;
        for (Ticket ticket : tickets) {
            bookedSeats.add(ticket.getSeatNumber());
        }
        System.out.println("============================================================");
        System.out.println("|                        UPSIDE                            |");
        System.out.println("============================================================");
        for (Seat seat : seats) {
            String seatStatus = bookedSeats.contains(seat.getSeatNumber()) ? "\u001B[31m" + seat.getSeatNumber()+ "\u001B[0m " : seat.getSeatNumber();
            System.out.printf("[ %-2s","");
            System.out.printf("%-3s ]",seatStatus);
            counter++;

            if(counter%5 == 0){
                System.out.println();
            }
        }
        System.out.println("============================================================");
        System.out.println("|                        SCREEN                            |");
        System.out.println("============================================================");
        System.out.println();
    }
}
