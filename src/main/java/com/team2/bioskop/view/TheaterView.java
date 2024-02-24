package com.team2.bioskop.view;

import com.team2.bioskop.service.TheaterServiceImpl;

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
                case 1 -> TheaterServiceImpl.addTheater();
                case 2 -> TheaterServiceImpl.updateTheater();
                case 3 -> TheaterServiceImpl.deleteTheater();
                case 4 -> TheaterServiceImpl.readTheater();
                case 5 -> checkFilm = false;
                default-> checkFilm = true;
            }
        }while(checkFilm);
    }
}
