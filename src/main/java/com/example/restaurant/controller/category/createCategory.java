package com.example.restaurant.controller.category;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class createCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/category/createCategory.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nameCategory = req.getParameter("nameCategory");
            String photo = req.getParameter("photo");
            Categories obj = new Categories(nameCategory,photo);

            if(!obj.isValid()){
                req.setAttribute("errors",obj.getErrors());
                req.getRequestDispatcher("/admin/category/createCategory.jsp").forward(req,resp);
                return;
            }
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.save(obj);
            resp.sendRedirect("/category/list");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
