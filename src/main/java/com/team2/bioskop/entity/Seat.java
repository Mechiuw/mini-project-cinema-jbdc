package com.team2.bioskop.entity;

public class Seat {
    private int id;
    private String seatNumber;
    private int theaterId;

    public Seat(final String seatNumber, final int theaterId) {
        this.seatNumber = seatNumber;
        this.theaterId = theaterId;
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
