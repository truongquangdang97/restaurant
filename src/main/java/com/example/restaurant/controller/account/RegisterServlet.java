package com.example.restaurant.controller.account;



import com.example.restaurant.entity.Account;
import com.example.restaurant.model.AccountModel;
import com.example.restaurant.util.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

public class RegisterServlet extends HttpServlet {
    private AccountModel accountModel = new AccountModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String fullName =req.getParameter("fullName");
        String passWord = req.getParameter("passwordHash");
//        String comfirmPassword = req.getParameter("comfirmPassword");
        Account account = new Account();
        account.setUserName(userName);
        account.setFullName(fullName);
        String salt = PasswordHandler.generateSalt();
        account.setSalt(salt);
        String passwordHash = PasswordHandler.getMd5(passWord,salt);
        account.setPasswordHash(passwordHash);
        account.setStatus(1);
        account.setCreateAt(Calendar.getInstance().getTime().toString());
        System.out.println(account);
        try {
            boolean result = accountModel.save(account);
            if (result){
                resp.getWriter().println("register succcess");
            }else {
                resp.getWriter().println("Error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
