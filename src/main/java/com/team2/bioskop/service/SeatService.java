package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;

public interface SeatService {
    void getAllSeat();

    boolean getSeatById(int id);
    boolean createSeat(String seatNumber, int theaterId);

    void createManySeat(Theater theater);

    boolean updateSeat(int id, String seatNumber, int theaterId);
    boolean deleteSeat(int id);
}
