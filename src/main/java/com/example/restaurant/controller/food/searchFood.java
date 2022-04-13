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
import java.util.List;

public class searchFood extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameSearch = req.getParameter("search");
        FoodModel foodModel = new FoodModel();
        try {
            CategoryModel categoryModel = new CategoryModel();
            List<Foods> list = foodModel.search(nameSearch);
            List<Foods> foodsList = foodModel.findAll();
            List<Categories> listCategory = categoryModel.findAll();
            req.setAttribute("foodsList",foodsList);
            req.setAttribute("listCategory",listCategory);
            req.setAttribute("list",list);
            req.getRequestDispatcher("/admin/food/lists.jsp").forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
