package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Rating;



import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class RatingsRepositories {

    public static void insert(Connection connect,Rating rating){
        PreparedStatement preparedStatement = null;

        try{
            String Insertquery ="insert into t_rating (code,description) values ( ? , ? );";
            preparedStatement = connect.prepareStatement(Insertquery);
            preparedStatement.setString(1, rating.getCode());
            preparedStatement.setString(2, rating.getDescription());
            preparedStatement.executeUpdate();
            System.out.println(" insert data success ");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void read(Connection connect){
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            String query ="select * from t_rating" ;
            preparedStatement = connect.prepareStatement(query);
            set = preparedStatement.executeQuery();
            System.out.println("read testing complete");
            while (set.next()){
                System.out.print(set.getInt(1)+" ");
                System.out.print(set.getString(2)+" ");
                System.out.println(set.getString(3)+" ");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void update(Connection connect, Rating rating){
        PreparedStatement preparedStatement = null;
        try{
            String query ="update t_rating set code = ? , description = ? where code = ? and description = ? ; " ;
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, rating.getCodeUpdateNew());
            preparedStatement.setString(2, rating.getDescriptionUpdateNew());
            preparedStatement.setString(3, rating.getCodeUpdateOld());
            preparedStatement.setString(4, rating.getDescriptionUpdateOld());
            preparedStatement.executeUpdate();
            System.out.println("update complete");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void delete(Connection connect,String deletionRating){
        PreparedStatement preparedStatement = null;
        try{
            String query ="delete from t_rating where code = " + deletionRating;
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("deletion complete");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
