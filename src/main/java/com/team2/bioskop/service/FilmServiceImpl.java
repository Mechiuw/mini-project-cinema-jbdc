package com.team2.bioskop.service;

import com.team2.bioskop.entity.Film;
import com.team2.bioskop.repositories.FilmRepositories;
import com.team2.bioskop.util.Validation;

import java.sql.Date;
import java.util.Scanner;

public class FilmServiceImpl {
    static Scanner input = new Scanner(System.in);
    public static void insert(){
        System.out.println("Input Film Tittle : ");
        String tittle = input.nextLine();
        System.out.println("Input Film duration : ");
        int duration = input.nextInt();
        input.nextLine();

        Date showDate;
        do {
            System.out.println("Input Show Date : ");
            String date = input.nextLine();
            showDate = Validation.getDate(date);
        }while (showDate == null);

        System.out.println("Input Price : ");
        int price = input.nextInt();
        System.out.println("Input Rating : ");
        int rating = input.nextInt();
        input.nextLine();

        Film film = new Film(tittle, duration, showDate, price, rating);
        FilmRepositories.insertFilm(film);
    }

    public static void update(){
        FilmRepositories.showAllFilm();
        System.out.println("Input ID Film Update : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("Input Film Tittle : ");
        String tittle = input.nextLine();
        System.out.println("Input Film duration : ");
        int duration = input.nextInt();
        input.nextLine();

        Date showDate;
        do {
            System.out.println("Input Show Date : ");
            String date = input.nextLine();
            showDate = Validation.getDate(date);
        }while (showDate == null);

        System.out.println("Input Price : ");
        int price = input.nextInt();
        System.out.println("Input Rating : ");
        int rating = input.nextInt();
        input.nextLine();

        Film film = new Film(tittle, duration, showDate, price, rating);
        FilmRepositories.updateFilm(film, id);
    }

    public static void delete(){
        FilmRepositories.showAllFilm();
        System.out.println("Input ID Film Delete : ");
        int id = input.nextInt();
        input.nextLine();
        FilmRepositories.deleteFilm(id);
    }

    public static void show(){
        FilmRepositories.showAllFilm();
    }
}
