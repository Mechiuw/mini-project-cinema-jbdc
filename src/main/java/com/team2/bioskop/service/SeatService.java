package com.team2.bioskop.service;

public interface SeatService {
    void getAllSeat();

    boolean getSeatById(int id);
    boolean createSeat(int id, String seatNumber, int theaterId);
    boolean updateSeat(int id, String seatNumber, int theaterId);
    boolean deleteSeat(int id);
}
