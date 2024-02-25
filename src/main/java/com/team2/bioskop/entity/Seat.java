package com.team2.bioskop.entity;

public class Seat {
    private int id;
    private String seatNumber;
    private int theaterId;

    private String theaterNumber;

    public Seat(final String seatNumber, final int theaterId) {
        this.seatNumber = seatNumber;
        this.theaterId = theaterId;
    }

    public Seat(final int id, final String seatNumber, final int theaterId) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.theaterId = theaterId;
    }

    public Seat(){

    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(String theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getTheaterId() {
        return theaterId;
    }
}
