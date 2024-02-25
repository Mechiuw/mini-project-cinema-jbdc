package com.team2.bioskop.service;

import com.team2.bioskop.entity.Customer;
import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.entity.Ticket;
import com.team2.bioskop.repositories.TheaterRepositories;
import com.team2.bioskop.repositories.TicketRepositories;
import com.team2.bioskop.util.SeatUtil;
import com.team2.bioskop.util.BuyTicketUtil;
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

        if (BuyTicketUtil.checkRemindStockSeat(theaterNumber)) {
            System.out.println("Seat stock has run out");
            return;
        }

        TicketRepositories.showTicketAvailable(theaterNumber);

        System.out.println("Select Your Seat :");
        System.out.println("RED (BOOKED)/ WHITE (AVAILABLE)");
        String seatNumber = input.nextLine();

        boolean check = true;
        do{
            if (!SeatUtil.getTicketSeat(seatNumber)){
                InvoiceView.view(customerName,filmId,theaterNumber,seatNumber);

                Ticket ticket = new Ticket();
                TicketRepositories.insert(ticket, customerName, seatNumber);
                check = false;
            }else{
                System.out.println("SEAT BOOKED, PLEASE CHOOSE SEAT AVAILABLE!!");
                System.out.println("Do You Want A Transaction? (yes/no)");
                String quest = input.nextLine();
                if(quest.equals("yes")){
                    TicketRepositories.showTicketAvailable(theaterNumber);
                    System.out.println("Select Your Seat :");
                    System.out.println("RED (BOOKED)/ WHITE (AVAILABLE)");
                    seatNumber = input.nextLine();
                    check = true;
                }else{
                    check = false;
                }
            }
        }while(check);
    }

}
