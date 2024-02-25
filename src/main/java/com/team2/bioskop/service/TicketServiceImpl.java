package com.team2.bioskop.service;

import com.team2.bioskop.entity.Ticket;
import com.team2.bioskop.repositories.TheaterRepositories;
import com.team2.bioskop.repositories.TicketRepositories;
import com.team2.bioskop.view.InvoiceView;

import java.util.Scanner;

public class TicketServiceImpl implements TicketService{
    static Scanner input = new Scanner(System.in);

    public void buyTicket(){
        System.out.println("Input Your Name : ");
        String customerName = input.nextLine();

        FilmService filmService = new FilmServiceImpl();
        filmService.showFilm();

        System.out.println("Select Your Film : ");
        int filmId = input.nextInt();
        input.nextLine();
        TheaterRepositories.readTheater(filmId);

        System.out.println("Select Theater : ");
        String theaterNumber = input.nextLine();
        TicketRepositories.showTicketAvailable(theaterNumber);

        System.out.println("Select Your Seat :");
        System.out.println("RED (BOOKED)/ WHITE (AVAILABLE)");
        String seatNumber = input.nextLine();

        InvoiceView.view(customerName,filmId,theaterNumber,seatNumber);

        Ticket ticket = new Ticket();
        TicketRepositories.insert(ticket, customerName, seatNumber);

    }
}
