package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.AuthenticationModule;
import com.team2.bioskop.service.CustomerServiceImpl;
import com.team2.bioskop.view.CustomerView;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticatorDb {
    public static void checkDB(Connection connect, AuthenticationModule authenticationModule){
        PreparedStatement preparedStatement = null;
        ResultSet sets = null;
        try {
            String validate = "select name from m_customer where name = ?;";
            preparedStatement = connect.prepareStatement(validate);
            preparedStatement.setString(1,authenticationModule.getLoginCheck());
            sets = preparedStatement.executeQuery();

            boolean found = false;
            if(sets.next()){
                System.out.println("username found");
                CustomerView.view();
                found = true;
            }

            if(sets.next() == found){
                System.out.println("user not found || need to sign up first");
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                customerService.addCustomer();
                CustomerView.view();
            }
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
