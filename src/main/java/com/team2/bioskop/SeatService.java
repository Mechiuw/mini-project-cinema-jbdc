package com.team2.bioskop;

public class SeatService {
    public void getAllSeat() {
        try {
            System.out.printf("%-20s%-20s%-20s%n", "id", "seat_number", "theater_id");
            System.out.println("-".repeat(50));
            SeatRepository.readAll();
        } catch (Exception e) {
            System.out.println("Data not found");
            System.out.println(e.getMessage());
        }
    }

    public boolean getSeatById(int id) {
        try {
            var seat = SeatRepository.readOne(id);
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

    public boolean createSeat(int id, String seatNumber, int theaterId) {
        try {
            var seat = SeatRepository.readOne(id);
            if (seat != null) {
                System.out.println("Id Already Used");
                return false;
            }
            SeatRepository.addSeat(id, seatNumber, theaterId);
            System.out.println(">>> Adding Success <<<");
            return true;
        } catch (Exception e) {
            System.out.println("Add seat is failed");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateSeat(int id, String seatNumber, int theaterId) {
        try {
            var seat = SeatRepository.readOne(id);
            String uSeatNumber = (seatNumber.isEmpty()) ? seat.getSeatNumber() : seatNumber;
            int uTheaterId = (theaterId == 0) ? seat.getTheaterId() : theaterId;
            SeatRepository.update(id, uSeatNumber, uTheaterId);
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
            var seat = SeatRepository.readOne(id);
            if (seat == null) {
                System.out.println("Seat not found");
                return false;
            }
            SeatRepository.delete(id);
            System.out.println(">>> DELETE SUCCESSFULLY <<<");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
