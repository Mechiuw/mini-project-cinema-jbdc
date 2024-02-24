package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;

import java.sql.SQLException;

public class SeatServiceImp implements SeatService {
    public void getAllSeat() {
        try {
            System.out.printf("%-20s%-20s%-20s%n", "id", "seat_number", "theater_id");
            System.out.println("-".repeat(50));
            SeatRepositories.readAll();
        } catch (Exception e) {
            System.out.println("Data not found");
            System.out.println(e.getMessage());
        }
    }

    public boolean getSeatById(int id) {
        try {
            var seat = SeatRepositories.readOne(id);
            int idx = seat.getId();
            String seatNumber = seat.getSeatNumber();
            int theaterId = seat.getTheaterId();
            System.out.printf("%-20s%-20s%-20s\n", "id", "seat_number", "seat");
            System.out.println("-".repeat(50));
            System.out.printf("%-20d%-20s%-20s", idx, seatNumber, theaterId);
            return true;
        } catch (Exception e) {
            System.out.println("Seat not found");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean createSeat(String seatNumber, int theaterId) {
        try {
            SeatRepositories.addSeat(seatNumber, theaterId);
            System.out.println(">>> Adding Success <<<");
            return true;
        } catch (Exception e) {
            System.out.println("Add seat is failed");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void createManySeat(Theater theater) {
        try {

            int theaterId = theater.getId();
            String theaterNumber = theater.getTheater_number();
            int stockSeatTheater = theater.getStock();

            String seatNumberPattern = "S-" + theaterNumber + "-";

            for (int i = 1; i <= stockSeatTheater; i++) {
                SeatRepositories.addSeat(seatNumberPattern + i, theaterId);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateSeat(int id, String seatNumber, int theaterId) {
        try {
            var seat = SeatRepositories.readOne(id);
            String uSeatNumber = (seatNumber.isEmpty()) ? seat.getSeatNumber() : seatNumber;
            int uTheaterId = (theaterId <= 0) ? seat.getTheaterId() : theaterId;
            SeatRepositories.update(id, uSeatNumber, uTheaterId);
            System.out.println(">>> UPDATE SUCCESSFULLY <<<");
            return true;
        } catch (Exception e) {
            System.out.println("Seat not found");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteSeat(int id) {
        try {
            var seat = SeatRepositories.readOne(id);
            if (seat == null) {
                System.out.println("Seat not found");
                return false;
            }
            SeatRepositories.delete(id);
            System.out.println(">>> DELETE SUCCESSFULLY <<<");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
