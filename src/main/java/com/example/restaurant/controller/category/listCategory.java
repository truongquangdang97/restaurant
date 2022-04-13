package com.example.restaurant.controller.category;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class listCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryModel categoryModel = new CategoryModel();
        try {
            List<Categories> listCategory = categoryModel.findAll();
            req.setAttribute("listCategory",listCategory);
            req.getRequestDispatcher("/admin/category/listCategory.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
