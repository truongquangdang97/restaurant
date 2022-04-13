package com.example.restaurant.controller.food;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.entity.Foods;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class deleteFood extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FoodModel foodModel = new FoodModel();
        try {
            Foods obj = foodModel.findById(id);
            if (obj==null){
                resp.setStatus(404);
                resp.sendRedirect("not ok");
            }else {
                foodModel.delete(id);
                resp.sendRedirect("/food/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
