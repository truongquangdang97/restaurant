package com.example.restaurant.controller.account;



import com.example.restaurant.entity.Account;
import com.example.restaurant.entity.Categories;
import com.example.restaurant.model.AccountModel;
import com.example.restaurant.model.CategoryModel;
import com.example.restaurant.util.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class LoginServlet extends HttpServlet {
    AccountModel accountModel = new AccountModel();
//    int max_count = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passwordHash");
        try {
          Account account =  accountModel.findAccountByUserName(userName);
          if (account==null){
              resp.getWriter().println("Sai thong tin tai khoan .");
              return;
          }


          boolean result = PasswordHandler.checkPassword(passWord,account.getPasswordHash(),account.getSalt());
          if (result){
              HttpSession session = req.getSession();
              session.setAttribute("currentAccount",account);

              CategoryModel categoryModel = new CategoryModel();
              List<Categories> listCategory = categoryModel.findAll();
              req.setAttribute("listCategory",listCategory);
              resp.getWriter().println("dang nhap okok ");
              req.getRequestDispatcher("/admin/category/listCategory.jsp").forward(req,resp);
          }else {
              resp.getWriter().println("dang nhap that bai nhes");
          }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
