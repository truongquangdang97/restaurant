package com.example.restaurant.model;

import com.example.restaurant.entity.Categories;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class categoryModelTest {

    @Test
    void save() {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.save(new Categories("ngo","1234567"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findAll() {
        CategoryModel categoryModel = new CategoryModel();
        try {
            List<Categories> list = categoryModel.findAll();
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findById() {
        CategoryModel categoryModel = new CategoryModel();
        try {
            Categories categories = categoryModel.findById(1);
            System.out.println(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void update() {
        CategoryModel categoryModel = new CategoryModel();

        try {
            Categories categories = categoryModel.findById(1);
            categories.setNameCategory("thai");
            categoryModel.update(1,categories);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void delete() {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.delete(14);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}