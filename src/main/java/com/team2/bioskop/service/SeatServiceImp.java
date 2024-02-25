package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.repositories.TheaterRepositories;

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
            var theater = TheaterRepositories.readDataById(theaterId);
            if (theater == null) {
                System.out.println("Theater Not Found");
                return false;
            }
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

            System.out.println(">>> CREATE SEAT SUCCESSFULLY <<<");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean createSeat(Theater theater) {
        try {
            int theaterId = theater.getId();
            String theaterNumber = theater.getTheater_number();
            int stockSeatTheater = theater.getStock();
            int filmId = theater.getFilm_id();

            String seatNumberPattern = "S-" + theaterNumber + "-";

            Theater t = new Theater(theaterId, theaterNumber, stockSeatTheater + 1, filmId);

            var listSeat = SeatRepositories.readAll(theaterId);

            String lastSeatNumber = listSeat.get(listSeat.size() - 1).getSeatNumber();
            String[] lastSeatNumberSplit = lastSeatNumber.split("-");
            int extractIndexSeat = Integer.parseInt(lastSeatNumberSplit[lastSeatNumberSplit.length - 1]);

            SeatRepositories.addSeat(seatNumberPattern + (extractIndexSeat + 1), theaterId);
            TheaterRepositories.updateData(t);

            System.out.println(">>> CREATE SEAT SUCCESSFULLY <<<");

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateSeat(int id, String seatNumber, int theaterId) {
        try {
            var seat = SeatRepositories.readOne(id);
            var theater = TheaterRepositories.readDataById(id);

            if (seat == null) {
                System.out.println("Seat not found");
                return false;
            }

            if (theater == null) {
                System.out.println("Theater not found");
                return false;
            }

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

    public boolean deleteSeat(String seatNumber) {
        try {
            var seat = SeatRepositories.readOne(seatNumber);
            if (seat == null) {
                System.out.println("Seat not found");
                return false;
            }

            var theater = TheaterRepositories.readDataById(seat.getTheaterId());
            if (theater == null) {
                System.out.println("Theater not found");
                return false;
            }

            if (seat.getTheaterId() != theater.getId()) {
                System.out.println("Theater ID from seat and theater does not match");
                return false;
            }

            Theater t = new Theater(theater.getId(), theater.getTheater_number(),
                    theater.getStock() - 1, theater.getFilm_id());

            TheaterRepositories.updateData(t);
            SeatRepositories.delete(seat.getId());

            System.out.println(">>> DELETE SUCCESSFULLY <<<");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
