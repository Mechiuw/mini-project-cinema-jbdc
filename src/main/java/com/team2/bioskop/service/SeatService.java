package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;

public interface SeatService {
    void getAllSeat();

    boolean getSeatById(int id);
    boolean createSeat(String seatNumber, String theaterNumber);

    boolean createManySeat(Theater theater);

    boolean updateSeat(int id, String seatNumber, String theaterNumber);
    boolean deleteSeat(int id);
}
