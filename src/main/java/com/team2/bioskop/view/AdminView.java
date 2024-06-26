package com.team2.bioskop.view;

import com.team2.bioskop.service.FilmServiceImpl;

import java.util.Scanner;

public class AdminView {
    public static void viewAdmin(){
        boolean checkAdmin = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("=================ADMIN ENIGMA XXI================");
            System.out.println("1. FILM");
            System.out.println("2. THEATER");
            System.out.println("3. SEAT");
            System.out.println("4. RATING");
            System.out.println("5. SHOW ALL TRANSACTION");
            System.out.println("6. BACK TO MAIN MENU");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseAdmin = input.nextInt();
            input.nextLine();

            switch (chooseAdmin){
                case 1 -> FilmView.view();
                case 2 -> TheaterView.view();
                case 3 -> SeatView.SeatMenu();
                case 4 -> RatingView.view();
                case 5 -> TransactionView.view();
                case 6 -> checkAdmin = false;
                default-> checkAdmin = true;
            }
        }while(checkAdmin);
    }
}
