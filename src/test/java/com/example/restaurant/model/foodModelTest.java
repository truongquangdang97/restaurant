package com.example.restaurant.model;

import com.example.restaurant.entity.Foods;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class foodModelTest {

//    @Test
//    void save() {
//        FoodModel foodModel = new FoodModel();
//        try {
//            foodModel.save(new Foods("cho","rat ngon","anh",1,12,15));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void delete() {
        FoodModel foodModel = new FoodModel();
        try {
            foodModel.delete(2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll() {
        FoodModel foodModel = new FoodModel();
        try {
           List<Foods> list = foodModel.findAll();
           System.out.printf(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findById() {
        FoodModel foodModel = new FoodModel();
        try {
            Foods foods = foodModel.findById(13);
            System.out.println(foods);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {
        FoodModel foodModel = new FoodModel();
        try {
            Foods foods = foodModel.findById(13);
            foods.setNameFood("quaqffdng");
            foodModel.update(13,foods);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}