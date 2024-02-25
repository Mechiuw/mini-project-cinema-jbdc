package com.team2.bioskop.view;

import com.team2.bioskop.service.TicketService;
import com.team2.bioskop.service.TicketServiceImpl;

public class TransactionView {
    public static void view(){
        TicketService ticketService = new TicketServiceImpl();
        ticketService.showTicket();
    }
}
