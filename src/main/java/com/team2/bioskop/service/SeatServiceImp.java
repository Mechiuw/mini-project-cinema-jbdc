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
            String theaterNumber = seat.getTheaterNumber();
            System.out.printf("%-20s%-20s%-20s\n", "id", "seat_number", "seat");
            System.out.println("-".repeat(50));
            System.out.printf("%-20d%-20s%-20s", idx, seatNumber, theaterNumber);
            return true;
        } catch (Exception e) {
            System.out.println("Seat not found");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean createSeat(String seatNumber, String theaterNumber) {
        try {
            SeatRepositories.addSeat(seatNumber, theaterNumber);
            System.out.println(">>> Adding Success <<<");
            return true;
        } catch (Exception e) {
            System.out.println("Add seat is failed");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean createManySeat(Theater theater) {
        try {
            int theaterId = theater.getId();
            String theaterNumber = theater.getTheater_number();
            int stockSeatTheater = theater.getStock();

            String seatNumberPattern = "S-" + theaterId + "-";

            for (int i = 1; i <= stockSeatTheater; i++) {
                createSeat(seatNumberPattern + i, theaterNumber);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateSeat(int id, String seatNumber, String theaterNumber) {
        try {
            var seat = SeatRepositories.readOne(id);
            String uSeatNumber = (seatNumber.isEmpty()) ? seat.getSeatNumber() : seatNumber;
            String uTheaterNumber = (theaterNumber.isEmpty()) ? seat.getTheaterNumber() : theaterNumber;
            SeatRepositories.update(id, uSeatNumber, uTheaterNumber);
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
