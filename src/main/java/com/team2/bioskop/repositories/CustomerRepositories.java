package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.Customer;


import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomerRepositories {
    public static void insert(Connection connect, Customer customer){
        PreparedStatement preparedStatement = null;
        try{
            String query ="insert into m_customer (name,birth_date) values ( ?, ? ) ;";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDate(2, Date.valueOf(String.valueOf(customer.getBirth_date())));
            preparedStatement.executeUpdate();
            System.out.println("data added");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void read(Connection connect){
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try{
            String query ="select * from m_customer " ;
            preparedStatement = connect.prepareStatement(query);
            set = preparedStatement.executeQuery();
            System.out.println("read testing complete");
            while (set.next()){
                System.out.print(set.getString(1)+" ");
                System.out.print(set.getString(2)+" ");
                System.out.println(set.getString(3)+" ");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void update(Connection connect,Customer customer){
        PreparedStatement preparedStatement = null;
        try{
            String query ="update m_customer set ? = ? where ? = ? ; " ;
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,customer.getNameOrBirth());
            preparedStatement.setString(2,customer.getNewNameOrBirth());
            preparedStatement.setString(3,customer.getNameOrBirth());
            preparedStatement.setString(4,customer.getOldNameOrBirth());
            preparedStatement.executeUpdate();
            System.out.println("update complete");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
