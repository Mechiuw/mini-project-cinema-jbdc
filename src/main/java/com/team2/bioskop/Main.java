package com.team2.bioskop;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.repositories.TheaterRepositories;
import com.team2.bioskop.service.TheaterService;

public class Main {
    public static void main(String[] args) {
        // MainView.run();
//        var a = SeatRepositories.addSeat("T212", "A1000");
//        System.out.println(a.getId());
//        System.out.println(a.getSeatNumber());
//        System.out.println(a.getTheaterNumber());
//

        TheaterService.addTheater();

    }
}