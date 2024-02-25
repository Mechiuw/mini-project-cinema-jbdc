package com.team2.bioskop.util;

import com.team2.bioskop.entity.Film;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmUtil {
    public static Film readFilmId(int id) {
        Film film = null;
        try {
            var conn = DbConnector.connectToDb();
            String query = """
                    SELECT id FROM t_film WHERE id = ?;
                    """;
            PreparedStatement pr = conn.prepareStatement(query);
            pr.setInt(1, id);

            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                film = new Film();
                film.setId(rs.getInt("id"));
            }

            pr.close();
            rs.close();
            conn.close();

            return film;
        } catch (SQLException e) {
            System.out.println("Not Found");
        }
        return film;
    }
}
