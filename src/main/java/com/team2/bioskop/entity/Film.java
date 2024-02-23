package com.team2.bioskop.entity;

import java.sql.Date;

public class Film {
    String tittle = "";
    int duration;
    Date showDate;
    int price;
    int rating;

    public Film(String tittle, int duration, Date showDate, int price, int rating) {
        this.tittle = tittle;
        this.duration = duration;
        this.showDate = showDate;
        this.price = price;
        this.rating = rating;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
