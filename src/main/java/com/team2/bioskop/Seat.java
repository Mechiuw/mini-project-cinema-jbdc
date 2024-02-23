package com.team2.bioskop;

public class Seat {
    private int id;
    private String seatNumber;
    private int theaterId;

    public Seat(final int id, final String seatNumber, final int theaterId) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.theaterId = theaterId;
    }

    public int getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public int getTheaterId() {
        return theaterId;
    }
}
