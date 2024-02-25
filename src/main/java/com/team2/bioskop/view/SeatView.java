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
            System.out.println("1. Get All Seat");
            System.out.println("2. Get Seat By Id");
            System.out.println("3. Create Seat");
            System.out.println("4. Update Seat");
            System.out.println("5. Delete Seat");
            System.out.println("0. Exit From Seat Page");
            System.out.print("Choice: ");
            choice = Validation.checkNumberInput(input.nextLine());
            switch (choice) {
                case 0 -> {
                    loop = false;
                }
                case 1 -> seatService.getAllSeat();
                case 2 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;

                    do {
                        id = Validation.checkNumberInput(input.nextLine());
                    } while (id == -1);

                    isSuccess = seatService.getSeatById(id);
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("Enter Theater Number: ");
                    String theaterNumber = input.nextLine();
                    var theater = TheaterRepositories.readDataByTheaterNumber(theaterNumber);
                    if (theater == null) {
                        System.out.println("Theater Not Found");
                        return;
                    }
                    isSuccess = seatService.createSeat(theater);
                    System.out.println();
                }

                case 4 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;
                    do {
                        id = Validation.checkNumberInput(input.nextLine());
                    } while (id == -1);

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = input.nextLine();

                    System.out.print("Enter Theater Number: ");
                    int theaterId;
                    do {
                        theaterId = Validation.checkNumberInput(input.nextLine());
                    } while (theaterId == -1);

                    isSuccess = seatService.updateSeat(id, seatNumber, theaterId);
                    System.out.println();

                }
                case 5 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;
                    do {
                        id = Validation.checkNumberInput(input.nextLine());
                    } while (id == -1);

                    isSuccess = seatService.deleteSeat(id);
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
