package com.team2.bioskop.entity;

public class Seat {
    private int id;
    private String seatNumber;
    private String theaterNumber;

    public Seat(final int id, final String seatNumber, final String theaterNumber) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.theaterNumber = theaterNumber;
    }

    public int getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTheaterNumber() {
        return theaterNumber;
    }
}
