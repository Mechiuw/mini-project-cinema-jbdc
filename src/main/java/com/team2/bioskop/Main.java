package com.team2.bioskop;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.service.SeatServiceImp;
import com.team2.bioskop.service.TheaterService;

public class Main {
    public static void main(String[] args) {
        var seat = new SeatServiceImp();

        SeatRepositories.readAll();
        TheaterService.readTheater();
        // seat.createSeat(new Theater(2, "T988", 10, 5));

    }
}