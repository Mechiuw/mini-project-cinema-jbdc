package com.team2.bioskop.service;

import com.team2.bioskop.entity.Customer;
import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.entity.Ticket;
import com.team2.bioskop.repositories.TheaterRepositories;
import com.team2.bioskop.repositories.TicketRepositories;
import com.team2.bioskop.util.CustomerUtil;
import com.team2.bioskop.view.InvoiceView;

import java.util.Scanner;

public class TicketServiceImpl implements TicketService{
    static Scanner input = new Scanner(System.in);

    public void buyTicket(){
        Customer customer = null;
        String customerName;
        do {
            System.out.println("Input Your Name : ");
             customerName = input.nextLine();
            customer = CustomerUtil.readCustomerByName(customerName);
            if (customer == null) {
                System.out.println("Customer is not found");
                System.out.println();
            }
        } while (customer == null);


        FilmService filmService = new FilmServiceImpl();
        filmService.showFilm();

        System.out.println("Select Your Film : ");
        int filmId = input.nextInt();
        input.nextLine();
        TheaterRepositories.readTheater(filmId);

        Theater theater;
        String theaterNumber;
        do {
            System.out.println("Select Theater : ");
            theaterNumber = input.nextLine();
            theater = TheaterRepositories.readDataByTheaterNumber(theaterNumber);
            if (theater == null) {
                System.out.println("Theater is not found");
            }
        } while (theater == null);

        TicketRepositories.showTicketAvailable(theaterNumber);

        System.out.println("Select Your Seat :");
        System.out.println("RED (BOOKED)/ WHITE (AVAILABLE)");
        String seatNumber = input.nextLine();

        InvoiceView.view(customerName,filmId,theaterNumber,seatNumber);

        Ticket ticket = new Ticket();
        TicketRepositories.insert(ticket, customerName, seatNumber);

    }
}
