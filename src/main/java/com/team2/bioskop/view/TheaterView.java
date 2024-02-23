package com.team2.bioskop.view;

import com.team2.bioskop.service.TheaterService;
import com.team2.bioskop.util.DbConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TheaterView {
    public static void view(){
        boolean checkFilm = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("===================THEATER (CRUD)===================");
            System.out.println("1. INSERT THEATER");
            System.out.println("2. UPDATE THEATER BY ID");
            System.out.println("3. DELETE THEATER");
            System.out.println("4. SHOW ALL THEATER");
            System.out.println("5. BACK TO MENU ADMIN");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseFilm = input.nextInt();
            input.nextLine();
            switch (chooseFilm){
                case 1 -> TheaterService.addTheater();
                case 2 -> TheaterService.updateTheater();
                case 3 -> TheaterService.deleteTheater();
                case 4 -> TheaterService.readTheater();
                case 5 -> checkFilm = false;
                default-> checkFilm = true;
            }
        }while(checkFilm);
    }
}
