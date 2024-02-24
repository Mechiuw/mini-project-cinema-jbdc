package com.team2.bioskop.service;

import com.team2.bioskop.entity.Theater;
import com.team2.bioskop.util.DbConnector;
import com.team2.bioskop.repositories.TheaterRepositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TheaterService {
    public static Scanner input = new Scanner(System.in);

    public static void addTheater() {
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
                    System.out.println("Invalid input. Stock should be a non-negative integer. Please enter again:");
                    input.next();
                }
            }
            System.out.println("Input Film ID");
            Integer film_id = input.nextInt();

            TheaterRepositories.addData(new Theater(theater_number, stock, film_id));
            System.out.println("Successfully insert data");
            System.out.println("theater_number -> " + theater_number);
            System.out.println("stock -> " + stock);
            System.out.println("film_id -> " + film_id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Theater readTheater() {
        ResultSet rs;
        Theater theater = null;
        try {
            rs = TheaterRepositories.readData();
            System.out.println("ID | Theater Number | Stock | Title     |");
            while (rs.next()) {
                System.out.print(rs.getString("id") + "  | ");
                System.out.print(rs.getString("theater_number") + "             | ");
                System.out.print(rs.getString("stock") + "   | ");
                System.out.println(rs.getString("title") + " | ");
                theater.setId(rs.getInt("id"));
                theater.setTheater_number(rs.getString("theater_number"));
                theater.setStock(rs.getInt("stock"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return theater;
    }

    public static void updateTheater(){
        try {
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
            System.out.println("Input ID to Update");
            Integer id = input.nextInt();

            TheaterRepositories.updateData(new Theater(stock, film_id, id));
            System.out.println("Successfully update data");
            System.out.println("stock -> " + stock);
            System.out.println("film_id -> " + film_id);
            System.out.println("for id -> " + film_id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTheater() {
        try {
            System.out.println("Input Theater Number to Delete");
            String theater_number = input.nextLine();

            TheaterRepositories.deleteData(new Theater(theater_number));
            System.out.println("Succesfully delete data");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
