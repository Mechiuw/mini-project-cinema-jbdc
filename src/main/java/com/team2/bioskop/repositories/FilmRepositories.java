package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Film;
import com.team2.bioskop.util.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmRepositories {
    public static void insert(Film film) {
        try(Connection connection = DbConnector.connectToDb()){
            connection.setAutoCommit(false);

            String sqlSelect = """
                    SELECT id FROM t_rating WHERE id = ?;
                    """;

            PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlSelect);
            preparedStatementSelect.setInt(1, film.getRating());
            ResultSet resultSet = preparedStatementSelect.executeQuery();
            int result = 0;
            if(resultSet.next()){
                result = resultSet.getInt("id");
            }

            String sql = """
                    INSERT INTO t_film (title, duration, show_date, price, rating_id) VALUES
                    (?, ?, ?, ?, ?);
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getTittle());
            preparedStatement.setInt(2, film.getDuration());
            preparedStatement.setDate(3, film.getShowDate());
            preparedStatement.setInt(4, film.getPrice());
            preparedStatement.setInt(5, result);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.commit();
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    public static void update(Film film, int id){
        try(Connection connection = DbConnector.connectToDb()){
            String sql = """
                    UPDATE t_film SET title = ?, duration = ?, show_date = ?,
                    price = ?, rating_id = ? WHERE id = ?;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getTittle());
            preparedStatement.setInt(2, film.getDuration());
            preparedStatement.setDate(3, film.getShowDate());
            preparedStatement.setInt(4, film.getPrice());
            preparedStatement.setInt(5, film.getRating());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void delete (int id){
        try(Connection connection = DbConnector.connectToDb()){
            String sql = String.format("DELETE FROM t_film WHERE id = ?;");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Film> getAllFilm(){
        try(Connection connection = DbConnector.connectToDb()){
            List <Film> films = new ArrayList<>() ;
            String sql = """
                    SELECT t_film.id, t_film.title, t_film.duration, t_film.show_date
                    ,t_film.price ,t_rating.code
                    FROM t_film
                        JOIN t_rating ON t_film.rating_id = t_rating.id
                    GROUP BY t_film.id, t_rating.code;
                    """;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){;
                int id = resultSet.getInt("id");
                String tittle = resultSet.getString("title");
                int duration = resultSet.getInt("duration");
                Date showDate = resultSet.getDate("show_date");
                String rating = resultSet.getString("code");
                int price = resultSet.getInt("price");
                Film film = new Film(id, tittle, duration, showDate, price, rating);
                films.add(film);
            }
            statement.close();
            return films;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void showAllFilm(){
        List<Film> films = getAllFilm();

        System.out.println("\t\t\t\t\t\t\t\t\t\t======================FILM LIST=============================");
        System.out.printf("| %-3s | %-20s | %-30s | %-15s | %-20s | %-20s |\n",
                "ID", "Tittle", "Show Date", "Durtion",
                "Price", "Code");

        for (Film film : films) {
            System.out.printf("| %-3s | %-20s | %-30s | %-15s | %-20s | %-20s |\n",
                    film.getId(), film.getTittle(), film.getShowDate(), film.getDuration(),
                    film.getPrice(), film.getCode());
        }
    }

}