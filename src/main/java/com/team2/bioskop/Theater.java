package com.team2.bioskop;

public class Theater {
    private Integer id;
    private String theater_number;
    private String stock;
    private String film_id;

    public Theater(Integer id, String theater_number, String stock, String film_id) {
        this.id = id;
        this.theater_number = theater_number;
        this.stock = stock;
        this.film_id = film_id;
    }
}
