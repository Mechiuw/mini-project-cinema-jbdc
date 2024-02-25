package com.team2.bioskop.view;
import com.team2.bioskop.repositories.TheaterRepositories;
import com.team2.bioskop.service.SeatService;
import com.team2.bioskop.service.SeatServiceImp;
import com.team2.bioskop.util.Validation;

import java.util.Scanner;

public class SeatView {
    public static void SeatMenu() {
        boolean isSuccess = true;
        boolean loop = true;
        SeatService seatService = new SeatServiceImp();
        Scanner input = new Scanner(System.in);

        int choice;
        do {
            System.out.println("SEAT MENU: ");
            System.out.println("1. GET ALL SEAT");
            System.out.println("2. CREATE SEAT");
            System.out.println("3. DELETE SEAT");
            System.out.println("0. EXIT FROM SEAT PAGE");
            System.out.print("Choice: ");
            choice = Validation.checkNumberInput(input.nextLine());
            switch (choice) {
                case 0 -> {
                    loop = false;
                }
                case 1 -> {
                    seatService.getAllSeat();
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Enter Theater Number: ");
                    String theaterNumber = input.nextLine();
                    var theater = TheaterRepositories.readDataByTheaterNumber(theaterNumber);
                    if (theater == null) {
                        System.out.println("Theater Not Found");
                    } else {
                        isSuccess = seatService.createSeat(theater);
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = input.nextLine();
                    isSuccess = seatService.deleteSeat(seatNumber);
                    System.out.println();
                }
                default -> {
                    System.out.println(">>> Choice Nothing <<<");
                    isSuccess = false;
                }
            }
        } while (loop || choice == -1 || !isSuccess);

    }
}
