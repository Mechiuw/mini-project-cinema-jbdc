package com.team2.bioskop.util;

import com.team2.bioskop.entity.Seat;
import com.team2.bioskop.entity.Ticket;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.team2.bioskop.repositories.TicketRepositories;


public class BuyTicketUtil {
    public static boolean checkRemindStockSeat(String theaterName) {
        List<Seat> seats = TicketRepositories.getSeat(theaterName);
        List<Ticket> tickets = TicketRepositories.getSeatTicket(theaterName);
        return seats.size() == tickets.size();
    }
}
