package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;

public interface SeatService {
    void getAllSeat();
    void createManySeat(Theater theater);
    boolean getSeatById(int id);
    boolean createSeat(String seatNumber, int theaterId);
    boolean createSeat(Theater theater);
    boolean updateSeat(int id, String seatNumber, int theaterId);
    boolean deleteSeat(String seatNumber);
}
