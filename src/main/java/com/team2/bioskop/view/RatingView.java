package com.team2.bioskop.view;



import com.team2.bioskop.service.RatingService;
import com.team2.bioskop.service.RatingServiceImpl;


import java.util.Scanner;

public class RatingView {

    public static void view(){
        boolean checkRating = false;
        Scanner input = new Scanner(System.in);
        RatingService ratingService = new RatingServiceImpl();
        do {
            System.out.println("================RATING(CRUD)================");
            System.out.println(" 1. INSERT MOVIE RATING AND DESCRIPTIONS    ");
            System.out.println(" 2. SHOW ALL MOVIE RATING AND DESCRIPTIONS    ");
            System.out.println(" 3. UPDATE MOVIE RATING AND DESCRIPTIONS    ");
            System.out.println(" 4. DELETE MOVIE RATING AND DESCRIPTIONS   ");
            System.out.println("============================================");
            System.out.println("Choose Menu : ");
            int chooseRating = input.nextInt();
            input.nextLine();

            switch (chooseRating){
                case 1 -> ratingService.addRatings();
                case 2 -> ratingService.showRatings();
                case 3 -> ratingService.updateRatings();
                case 4 -> ratingService.deleteRatings();
                default-> checkRating = true;
            }
        }while(checkRating);
    }
}
