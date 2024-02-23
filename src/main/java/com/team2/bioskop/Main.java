package com.team2.bioskop;

import com.team2.bioskop.view.TheaterView;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        TheaterView.view();
    }
}