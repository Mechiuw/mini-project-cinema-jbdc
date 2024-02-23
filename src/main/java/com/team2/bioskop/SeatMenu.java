package com.team2.bioskop;

import com.enigma.validation.ValidationInput;

import java.util.Scanner;

public class SeatMenu {
    public static void SeatMenu() {
        boolean isSuccess = true;
        boolean loop = true;
        var seatService = new SeatService();
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
            choice = ValidationInput.check(input.nextLine());
            switch (choice) {
                case 0 -> {
                    loop = false;
                }
                case 1 -> seatService.getAllSeat();
                case 2 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;

                    do {
                        id = ValidationInput.check(input.nextLine());
                    } while (id == -1);

                    isSuccess = seatService.getSeatById(id);
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;
                    do {
                        id = ValidationInput.check(input.nextLine());
                    } while (id == -1);

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = input.nextLine();

                    System.out.print("Enter Theater ID: ");
                    int theaterId;

                    do {
                        theaterId = ValidationInput.check(input.nextLine());
                    } while (theaterId == -1);

                    isSuccess = seatService.createSeat(id, seatNumber, theaterId);
                    System.out.println();
                }

                case 4 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;
                    do {
                        id = ValidationInput.check(input.nextLine());
                    } while (id == -1);

                    System.out.print("Enter Seat Number: ");
                    String seatNumber = input.nextLine();

                    System.out.print("Enter Theater ID: ");
                    int theaterId;

                    do {
                        theaterId = ValidationInput.check(input.nextLine());
                    } while (theaterId == -1);

                    isSuccess = seatService.updateSeat(id, seatNumber, theaterId);
                    System.out.println();

                }
                case 5 -> {
                    System.out.print("Enter Seat ID: ");
                    int id;
                    do {
                        id = ValidationInput.check(input.nextLine());
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
