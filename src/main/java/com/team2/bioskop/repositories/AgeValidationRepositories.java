package com.team2.bioskop.repositories;

import com.team2.bioskop.entity.AuthenticationModule;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgeValidationRepositories {
public static Integer ageFound;

    public static void checkAgeDB(Connection connect,AuthenticationModule authenticationModule){
        PreparedStatement preparedStatement = null;
        ResultSet show = null;

        try {
            String validate = "SELECT EXTRACT(YEAR FROM AGE(CURRENT_DATE, birth_date)) AS age FROM m_customer WHERE name = ?";
            preparedStatement = connect.prepareStatement(validate);

            preparedStatement.setString(1, authenticationModule.getLoginCheck());
            show = preparedStatement.executeQuery();
            if(show.next()){
                ageFound = show.getInt(1);
            }else{
                System.out.println("not found");
            }

        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

}
