package com.team2.bioskop;
import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.service.SeatServiceImp;
import com.team2.bioskop.service.TheaterService;
import com.team2.bioskop.service.TheaterServiceImpl;

public class Main {
    public static void main(String[] args) {
        var seat = new SeatServiceImp();

//        SeatRepositories.readAll();
//        TheaterServiceImpl.readTheater();
        seat.createSeat(new Theater(6, "800", 21, 7));
        // SeatRepositories.readAll();
        // TheaterServiceImpl.readTheater();
    }
}