package com.team2.bioskop.view;

import com.team2.bioskop.repositories.FilmRepositories;

public class InvoiceView {
    public static void view(String customerName, int filmId, String theaterName, String seatId){
        String filmName = FilmRepositories.readById(filmId);
        System.out.println("=================================");
        System.out.println("|            INVOICE            |");
        System.out.println("=================================");
        System.out.println("| Name    : " + customerName + "\t\t\t\t|");
        System.out.println("| Film    : " + filmName + "\t|");
        System.out.println("| Theater : " + theaterName + "\t\t\t\t\t|");
        System.out.println("| Seat    : " + seatId + "\t\t\t\t\t|");
        System.out.println("=================================");
    }
}
