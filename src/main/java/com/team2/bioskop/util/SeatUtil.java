package com.team2.bioskop.util;

import com.team2.bioskop.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatUtil {
    public static Boolean getTicketSeat(String seatNumber){
        try(Connection connection = DbConnector.connectToDb()){
            String sql = """
                    Select s.seat_number
                    FROM trx_ticket t
                        JOIN
                        t_seat s ON s.id = t.seat_id
                        JOIN
                        t_theater h ON h.id = s.theater_id
                        JOIN
                    	t_film f ON f.id = h.film_id
                    	WHERE s.seat_number = ?
                    GROUP BY s.seat_number;
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, seatNumber);
            ResultSet resultSet = statement.executeQuery();
            String seat = "";
            while (resultSet.next()){;
                seat = resultSet.getString("seat_number");
                if(seat.equals(seatNumber)){
                    return true;
                }
            }
            statement.close();
            return false;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
