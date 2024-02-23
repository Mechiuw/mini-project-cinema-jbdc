package com.team2.bioskop.entity;

public class Theater {
    private Integer id;
    private String theater_number;
    private Integer stock;
    private Integer film_id;

    public Theater(String theater_number, Integer stock, Integer film_id) {
        this.theater_number = theater_number;
        this.stock = stock;
        this.film_id = film_id;
    }

    public Theater(Integer stock, Integer film_id, Integer id) {
        this.id = id;
        this.stock = stock;
        this.film_id = film_id;
    }

    public Theater(String theaterNumber) {
        this.theater_number = theaterNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getTheater_number() {
        return theater_number;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTheater_number(String theater_number) {
        this.theater_number = theater_number;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", theater_number='" + theater_number + '\'' +
                ", stock='" + stock + '\'' +
                ", film_id='" + film_id + '\'' +
                '}';
    }
}
