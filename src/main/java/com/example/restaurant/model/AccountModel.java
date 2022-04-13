package com.example.restaurant.model;


import com.example.restaurant.entity.Account;
import com.example.restaurant.util.ConnectionHelper;
import com.example.restaurant.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AccountModel {
    public boolean save(Account account)  throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//Kết nốt csdl
            PreparedStatement preparedStatement = /// thực thi câu lệnh truy vấn .
                    connection.prepareStatement(SQLConfig.INSERT_ACCOUNT); /// truy vấn khi truyền vào
            preparedStatement.setString(1, account.getUserName());// ứng với tùng giá trị
            preparedStatement.setString(2, account.getFullName());
            preparedStatement.setString(3, account.getPasswordHash());
            preparedStatement.setString(4, account.getSalt());
            preparedStatement.setString(5, account.getCreateAt());
            preparedStatement.setInt(6, account.getStatus());
            preparedStatement.setInt(7, account.getRole());
            preparedStatement.execute(); /// lưu
            return  true;
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  false;
    }
    public Account findAccountByUserName (String userName) throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//Kết nốt csdl
            PreparedStatement preparedStatement = /// thực thi câu lệnh truy vấn .
                    connection.prepareStatement(SQLConfig.SELECT_ACCOUNT_BY_USERNAME); /// truy vấn khi truyền vào
            preparedStatement.setString(1, userName);// ứng với tùng giá trị

            ResultSet resultSet =  preparedStatement.executeQuery(); /// lưu
            if (resultSet.next()){
                String userNameDataBase = resultSet.getString("userName");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                Account account = new Account();
                account.setUserName(userNameDataBase);
                account.setPasswordHash((passwordHash));
                account.setSalt(salt);
                account.setFullName(resultSet.getString("fullName"));
                account.setStatus(resultSet.getInt("status"));
                account.setErrorCount(resultSet.getInt("errorCount"));
                account.setCreateAt(resultSet.getString("createAt"));
                account.setRole(resultSet.getInt("role"));
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm--ss");
                    if (resultSet.getString("lockTime") != null){
                        account.setLockTime(LocalDateTime.parse(resultSet.getString("lockTime"),formatter));
                    }
                }catch (DateTimeParseException ex){
                    System.out.printf(ex.getMessage());
                }
//                account.setLockTime(LocalDateTime.parse(resultSet.getString("lockTime")));
                return  account;
            }
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  null;
    }

    public boolean lockAccount(String userName, Account account) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.LOCK_ACCOUNT); // truyền câu lệnh vào
            preparedStatement.setInt(1,account.getStatus());
            preparedStatement.setInt(2,account.getErrorCount());
            preparedStatement.setString(3,account.getLockTime().toString());
            preparedStatement.setString(4,userName);
            preparedStatement.execute();
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
