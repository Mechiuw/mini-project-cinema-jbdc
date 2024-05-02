package com.team2.bioskop.util;

import com.team2.bioskop.entity.AuthenticationModule;

import com.team2.bioskop.repositories.AgeValidationRepositories;

import java.sql.Connection;


public class AgeValidation {
    public static void validate(String loginCheck){
        try(Connection connect = DbConnector.connectToDb()){

            AuthenticationModule authenticationModule = new AuthenticationModule(loginCheck);
            AgeValidationRepositories.checkAgeDB(connect,authenticationModule);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
