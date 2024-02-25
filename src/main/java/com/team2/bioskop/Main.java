package com.team2.bioskop;
import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.service.SeatServiceImp;
import com.team2.bioskop.service.TheaterService;
<<<<<<< HEAD
import com.team2.bioskop.service.TheaterServiceImpl;

public class Main {
    public static void main(String[] args) {
        var seat = new SeatServiceImp();

=======
import com.team2.bioskop.view.MainView;

public class Main {
    public static void main(String[] args) {
        MainView.run();
>>>>>>> dd38c6fc1b25455b22eac5386d1bdafe0dec465e
    }
}