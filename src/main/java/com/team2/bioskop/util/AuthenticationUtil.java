package com.team2.bioskop.util;

import com.team2.bioskop.entity.AuthenticationModule;
import com.team2.bioskop.repositories.AuthenticatorDb;
import com.team2.bioskop.service.CustomerServiceImpl;
import com.team2.bioskop.view.CustomerView;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class AuthenticationUtil {
    public static void userInput(){
        try (Connection connect = DbConnector.connectToDb()){

            Scanner scan = new Scanner(System.in);
            System.out.println("ever been here? (yes/no)");
            String askAppearance = scan.nextLine();

            if (askAppearance.equalsIgnoreCase("yes")) {
                System.out.println("insert your registered name : ");
                String loginCheck = scan.nextLine();
                AuthenticationModule authenticationModule = new AuthenticationModule(loginCheck);
                AuthenticatorDb.checkDB(connect,authenticationModule);

            } else if(askAppearance.equalsIgnoreCase("no")){
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                customerService.addCustomer();
                CustomerView.view();
            } else {
                userInput();
            }

        }  catch ( SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
