package com.team2.bioskop.util;

import java.sql.Date;

public class Validation {

    public static Date getDate(String showDate)  {
        try {
            Date parsedDate = java.sql.Date.valueOf(showDate);
            return parsedDate;
        }catch (Exception e){
            System.out.println("Invalid Input Date");
        }
        return null;
    }

}
