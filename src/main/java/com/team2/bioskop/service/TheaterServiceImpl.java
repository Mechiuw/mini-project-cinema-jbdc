package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.repositories.SeatRepositories;
import com.team2.bioskop.repositories.TheaterRepositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TheaterServiceImpl implements TheaterService{
    public static Scanner input = new Scanner(System.in);

    public static void addTheater() {
        Theater theater = null;
        try {
            System.out.println("Input Theater Number");
            String theater_number = input.nextLine();
            System.out.println("Input Stock");
            int stock = -1;
            while (stock < 0) {
                try {
                    stock = input.nextInt();
                    if (stock < 0) {
                        System.out.println("Stock should be a non-negative integer. Please enter again:");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Stock must be an integer. Please enter again:");
                    input.next();
                    stock = -1;
                }
            }
            input.nextLine();

            System.out.println("Input Film ID");
            int film_id = -1;
            while (film_id <= 0) {
                try {
                    film_id = input.nextInt();
                    if (film_id <= 0) {
                        System.out.println("Stock should be a non-negative integer. Please enter again:");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Stock must be an integer. Please enter again:");
                    input.next();
                    film_id = -1;
                }
            }
            input.nextLine();

            theater = TheaterRepositories.addData(new Theater(theater_number, stock, film_id));
            System.out.println("Successfully insert data");
            System.out.println("| theater_number -> " + theater_number + " |");
            System.out.println("| stock -> " + stock + " |");
            System.out.println("| film_id -> " + film_id + " |");

            var seat = new SeatServiceImp();
            seat.createManySeat(theater);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//    public static Theater readTheater() {
//        ResultSet rs;
//        Theater theater = null;
//        try {
//            rs = TheaterRepositories.readData();
//
//            System.out.println("ID | Theater Number | Stock | Title     |");
//            while (rs.next()) {
//                System.out.print(rs.getString("id") + "  | ");
//                System.out.print(rs.getString("theater_number") + "             | ");
//                System.out.print(rs.getString("stock") + "   | ");
//                System.out.println(rs.getString("title") + " | ");
//                theater = new Theater(rs.getString("stock"),
//                        Integer.parseInt(rs.getString("film_id")),
//                        Integer.parseInt(rs.getString("id")));
//            }
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return theater;
//    }

    public static Theater readTheater() {
        ResultSet rs;
        Theater theater = null;
        try {
            rs = TheaterRepositories.readData();

            if (!rs.isBeforeFirst()) {
                System.out.println("No theaters found");
                return null;
            }

            System.out.println("| ID  | Theater Number  | Stock  | film_id |");
            while (rs.next()) {
                System.out.printf("| %-4s| %-16s| %-7s| %-7s |%n",
                        rs.getString("id"),
                        rs.getString("theater_number"),
                        rs.getString("stock"),
                        rs.getString("film_id"));
                theater = new Theater(rs.getString("stock"),
                        Integer.parseInt(rs.getString("film_id")),
                        Integer.parseInt(rs.getString("id")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return theater;
    }

    public static Theater updateTheater(){
        Theater theater = null;
        try {
            System.out.println("Input ID to Update");
            Integer id = input.nextInt();
            System.out.println("Input Stock");
            int stock = -1;
            while (stock < 0) {
                try {
                    stock = input.nextInt();
                    if (stock < 0) {
                        System.out.println("Stock should be a non-negative integer. Please enter again:");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Stock should be a non-negative integer. Please enter again:");
                    input.next();
                }
            }
            System.out.println("Input Film ID");
            Integer film_id = input.nextInt();

            TheaterRepositories.readDataById(id);

            theater = TheaterRepositories.updateData(new Theater(stock, film_id, id));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return theater;
    }

    public static Theater updateTheaterStock(){
        Theater theater = null;
        try {
            System.out.println("Input ID to Update");
            Integer id = input.nextInt();
            input.nextLine();

            System.out.println("Input Stock");
            int stock = -1;
            while (stock < 0) {
                try {
                    stock = input.nextInt();
                    if (stock < 0) {
                        System.out.println("Stock should be a non-negative integer. Please enter again:");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Stock should be a non-negative integer. Please enter again:");
                    input.next();
                }
            }

            var t = TheaterRepositories.readDataById(id);

            if (t == null) {
                System.out.println("Theater not found");
                return null;
            }

            theater = TheaterRepositories.updateData(new Theater(t.getId(),
                    t.getTheater_number(),
                    stock + t.getStock(),
                    t.getFilm_id()));


            String seatNumberPattern = "S-" + t.getTheater_number() + "-";
            for (int i = 1; i <= stock; i++) {
                SeatRepositories.addSeat(seatNumberPattern + (theater.getStock() + i),
                        theater.getId());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return theater;
    }

    public static void deleteTheater() {
        try {
            System.out.println("Input Theater Number to Delete");
            String theater_number = input.nextLine();
            SeatRepositories.deleteByTheaterNumber(theater_number);
            TheaterRepositories.deleteData(new Theater(theater_number));
            System.out.println("Succesfully delete data");
        }catch (Exception e) {
            System.out.println("Theater is in transaction");
        }
    }
}
