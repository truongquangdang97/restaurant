package com.example.restaurant.model;

import com.example.restaurant.entity.Foods;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class search {

    @Test
    void search() {
        FoodModel foodModel = new FoodModel();
        try {
            List<Foods> list = foodModel.search("quang");
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}