package com.team2.bioskop.view;

import com.team2.bioskop.service.FilmServiceImpl;

import java.util.Scanner;

public class FilmView {
    public static void view(){
        boolean checkFilm = true;
        Scanner input = new Scanner(System.in);
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
                case 1 -> FilmServiceImpl.insert();
                case 2 -> FilmServiceImpl.update();
                case 3 -> FilmServiceImpl.delete();
                case 4 -> FilmServiceImpl.show();
                case 5 -> checkFilm = false;
                default-> checkFilm = true;
            }
        }while(checkFilm);
    }
}
