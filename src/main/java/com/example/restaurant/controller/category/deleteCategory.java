package com.example.restaurant.controller.category;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class deleteCategory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        CategoryModel categoryModel = new CategoryModel();
        try {
            Categories obj = categoryModel.findById(id);
            if (obj==null){
                resp.setStatus(404);
                resp.sendRedirect("not ok");
            }else {
                categoryModel.delete(id);
                resp.sendRedirect("/category/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
