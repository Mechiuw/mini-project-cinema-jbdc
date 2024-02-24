package com.team2.bioskop.service;

import com.team2.bioskop.entity.Rating;
import com.team2.bioskop.repositories.RatingsRepositories;
import com.team2.bioskop.util.DbConnector;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class RatingServiceImpl implements RatingService {


    public void addRatings(){
        try (Connection connect = DbConnector.connectToDb()){
            Scanner scan = new Scanner(System.in);
            showRule();
            System.out.println("choose one of these -> (A,BO,R,D)");
            String movieCode = scan.nextLine();
            System.out.println("insert descriptions : ");
            String movieDescriptions = scan.nextLine();
            Rating rating = new Rating(movieCode,movieDescriptions);
            RatingsRepositories.insert(connect,rating);
        } catch(Exception e ){
            System.out.println();
        }
    }
    public void showRatings() {
        try(Connection connect = DbConnector.connectToDb()) {
            RatingsRepositories.read(connect);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateRatings(){
        try (Connection connect = DbConnector.connectToDb()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("insert previous movie rating code & description : ");
            String codeUpdateOld = scan.nextLine();
            String descriptionUpdateOld = scan.nextLine();
            System.out.println("insert new movie rating code & description : ");
            String codeUpdateNew = scan.nextLine();
            String descriptionUpdateNew = scan.nextLine();
            Rating rating = new Rating(codeUpdateOld,descriptionUpdateOld,codeUpdateNew,descriptionUpdateNew);
            RatingsRepositories.update(connect,rating);
        } catch(Exception e ){
            System.out.println();
        }
    }
    public void deleteRatings(){
        try (Connection connect = DbConnector.connectToDb()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("insert movie rating code : ");
            String deletionRating = scan.nextLine();
            RatingsRepositories.delete(connect,deletionRating);
        } catch(Exception e ){
            System.out.println();
        }
    }
    public static void showRule(){
        System.out.println("Rating conditions:\n" +
                "A: General\n" +
                "BO: Less than 13 years old is not allowed\n" +
                "R: Less than 18 years old is not allowed\n" +
                "D: Equal to or more than 21 years old is allowed\n" +
                "================================================\n");
    }

}
