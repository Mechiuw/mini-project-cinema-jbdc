package com.team2.bioskop.view;

import com.team2.bioskop.service.TicketService;
import com.team2.bioskop.service.TicketServiceImpl;

import java.util.Scanner;

public class TicketView {
    public static void view(){
        boolean checkFilm = true;
        Scanner input = new Scanner(System.in);
        TicketService ticketService = new TicketServiceImpl();
        do {
            System.out.println("===============TRANSACTION (CRUD)================");
            System.out.println("1. BUY TICKET");
            System.out.println("2. BACK TO MENU ADMIN");
            System.out.println("=================================================");
            System.out.println("Choose Menu : ");
            int chooseFilm = input.nextInt();
            input.nextLine();
            switch (chooseFilm){
                case 1 -> ticketService.buyTicket();
                case 2 -> checkFilm = false;
                default-> checkFilm = true;
            }
        }while(checkFilm);
    }
}
