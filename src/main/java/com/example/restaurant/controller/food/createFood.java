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
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class createFood extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name",name);
        CategoryModel categoryModel = new CategoryModel();
        try {
            List<Categories> listCategory = categoryModel.findAll();
            req.setAttribute("listCategory",listCategory);
            req.getRequestDispatcher("/admin/food/createFood.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameFood = req.getParameter("nameFood");
        String describeFood = req.getParameter("describeFood");
        String photoFood = req.getParameter("photoFood");
        int statusFood = Integer.parseInt(req.getParameter("statusFood"));
        int price = Integer.parseInt(req.getParameter("price"));
        int categoriesId = Integer.parseInt(req.getParameter("categoriesId"));
        Foods obj = new Foods(nameFood,describeFood,photoFood,statusFood,price,categoriesId);
        System.out.println(obj);
        if (!obj.isValid()){
            try {
                CategoryModel categoryModel = new CategoryModel();
                List<Categories> listCategory = categoryModel.findAll();;
                req.setAttribute("listCategory",listCategory);

                req.setAttribute("errors",obj.getErrors());
                req.getRequestDispatcher("/admin/food/createFood.jsp").forward(req,resp);
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
            FoodModel foodModel = new FoodModel();
            try {
                foodModel.save(obj);
                resp.sendRedirect("/food/list");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }
}
