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

public class editFood extends HttpServlet {
    FoodModel foodModel = new FoodModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Foods obj = foodModel.findById(id);
            if(obj==null){
                resp.setStatus(404);
                resp.getWriter().println("not ok ");
            }else {
                CategoryModel categoryModel = new CategoryModel();
                List<Categories> listCategory = categoryModel.findAll();
                req.setAttribute("listCategory",listCategory);
                req.setAttribute("obj",obj);
                req.getRequestDispatcher("/admin/food/editFood.jsp").forward(req,resp);
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
            Foods obj = foodModel.findById(id);
            if (obj==null){
                resp.setStatus(404);
                resp.getWriter().println("not ok ");
            }else {
                String nameFood = req.getParameter("nameFood");
                String describeFood = req.getParameter("describeFood");
                String photoFood = req.getParameter("photoFood");
                int statusFood = Integer.parseInt(req.getParameter("statusFood"));
                int price = Integer.parseInt(req.getParameter("price"));
                int categoriesId = Integer.parseInt(req.getParameter("categoriesId"));

                obj.setNameFood(nameFood);
                obj.setDescribeFood(describeFood);
                obj.setPhotoFood(photoFood);
                obj.setStatusFood(statusFood);
                obj.setPrice(price);
                obj.setCategoriesId(categoriesId);

                if (!obj.isValid()){
                    CategoryModel categoryModel = new CategoryModel();
                    List<Categories> listCategory = categoryModel.findAll();;
                    req.setAttribute("listCategory",listCategory);
                    req.setAttribute("obj",obj);
                    req.setAttribute("errors",obj.getErrors());
                    req.getRequestDispatcher("/admin/food/editFood.jsp").forward(req,resp);
                }
                System.out.println(obj);
                foodModel.update(id,obj);
                resp.sendRedirect("/food/list");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
