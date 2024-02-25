package com.team2.bioskop.service;

import com.team2.bioskop.entity.Film;
import com.team2.bioskop.repositories.FilmRepositories;
import com.team2.bioskop.util.CustomerUtil;
import com.team2.bioskop.util.FilmUtil;
import com.team2.bioskop.util.Validation;

import java.sql.Date;
import java.util.Scanner;

public class FilmServiceImpl implements FilmService{
    static Scanner input = new Scanner(System.in);
    public void insertFilm(){
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

        RatingService ratingService = new RatingServiceImpl();
        ratingService.showRatings();

        System.out.println("Input Rating : ");
        int rating = input.nextInt();
        input.nextLine();

        Film film = new Film(tittle, duration, showDate, price, rating);
        FilmRepositories.insert(film);
    }

    public void updateFilm(){
        FilmRepositories.showAllFilm();
        Film film = null;
        int id;
        do {
            System.out.println("Input ID Film Update : ");
            id = input.nextInt();
            input.nextLine();
            film = FilmUtil.readFilmId(id);
            if(film == null){
                System.out.println("FILM NOT FOUND");
            }
        } while (film == null);


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

        RatingService ratingService = new RatingServiceImpl();
        ratingService.showRatings();

        System.out.println("Input Rating : ");
        int rating = input.nextInt();
        input.nextLine();

        film = new Film(tittle, duration, showDate, price, rating);
        FilmRepositories.update(film, id);
    }

    public void deleteFilm(){
        FilmRepositories.showAllFilm();
        Film film = null;
        int id;
        do {
            System.out.println("Input ID Film Delete : ");
            id = input.nextInt();
            input.nextLine();
            film = FilmUtil.readFilmId(id);
            if(film == null){
                System.out.println("FILM NOT FOUND");
            }
        } while (film == null);
        FilmRepositories.delete(id);
    }

    public void showFilm(){
        FilmRepositories.showAllFilm();
    }
}
