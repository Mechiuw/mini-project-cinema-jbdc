package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Film;
import com.team2.bioskop.util.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmRepositories {
    public static void insertFilm(Film film) {
        try(Connection connection = DbConnector.connectToDb()){
            String sql = """
                    INSERT INTO t_film (tittle, duration, show_date, price, rating) VALUES
                    (?, ?, ?, ?, ?, ?);
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getTittle());
            preparedStatement.setInt(2, film.getDuration());
            preparedStatement.setDate(3, film.getShowDate());
            preparedStatement.setInt(4, film.getPrice());
            preparedStatement.setInt(5, film.getRating());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}