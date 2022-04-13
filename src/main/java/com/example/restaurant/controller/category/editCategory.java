package com.example.restaurant.controller.category;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class editCategory extends HttpServlet {
    CategoryModel categoryModel = new CategoryModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Categories obj = categoryModel.findById(id);
            if(obj==null){
                resp.setStatus(404);
                resp.getWriter().println("not ok ");
            }else {
                req.setAttribute("obj",obj);
                req.getRequestDispatcher("/admin/category/editCategory.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Categories obj = categoryModel.findById(id);
            if (obj==null){
                resp.setStatus(404);
                resp.getWriter().println("not ok ");
            }else {
                String nameCategory = req.getParameter("nameCategory");
                String photo = req.getParameter("photo");

                obj.setNameCategory(nameCategory);
                obj.setPhoto(photo);
                System.out.println(obj);

                categoryModel.update(id,obj);
                resp.sendRedirect("/category/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
