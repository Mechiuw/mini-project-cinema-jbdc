package com.team2.bioskop.view;

import com.team2.bioskop.service.FilmServiceImpl;

import java.util.Scanner;

public class FilmView {
    public static void view(){
        boolean checkFilm = true;
        Scanner input = new Scanner(System.in);
        FilmServiceImpl filmService = new FilmServiceImpl();
        do {
            System.out.println("===================FILM (CRUD)===================");
            System.out.println("1. INSERT FILM");
            System.out.println("2. UPDATE FILM BY ID");
            System.out.println("3. DELETE FILM BY ID");
            System.out.println("4. SHOW ALL FILM");
            System.out.println("5. BACK TO MENU ADMIN");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseFilm = input.nextInt();
            input.nextLine();

            switch (chooseFilm){
                case 1 -> filmService.insertFilm();
                case 2 -> filmService.updateFilm();
                case 3 -> filmService.deleteFilm();
                case 4 -> filmService.showFilm();
                case 5 -> checkFilm = false;
                default-> checkFilm = true;
            }
        }while(checkFilm);
    }
}
