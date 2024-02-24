package com.team2.bioskop.util;

import com.team2.bioskop.repositories.SeatRepositories;

import java.util.ArrayList;

public class Helper {
    public static int getLastIdFromTable() {
        var listData = SeatRepositories.readAll();
        ArrayList<Integer> listId = new ArrayList<>();
        for (com.team2.bioskop.entity.Seat listDatum : listData) {
            listId.add(listDatum.getId());
        }

        return listId.get(listId.size() - 1);
    }
}
