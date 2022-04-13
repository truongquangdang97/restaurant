package com.example.restaurant.model;

import com.example.restaurant.entity.Categories;
import com.example.restaurant.util.ConnectionHelper;
import com.example.restaurant.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel {
    public boolean save(Categories obj) throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//Kết nốt csdl
            PreparedStatement preparedStatement = /// thực thi câu lệnh truy vấn .
                    connection.prepareStatement(SQLConfig.INSERT_CATEGORIES); /// truy vấn khi truyền vào
            preparedStatement.setString(1, obj.getNameCategory());// ứng với tùng giá trị
            preparedStatement.setString(2, obj.getPhoto());// ứng với tùng giá trị
//            preparedStatement.setInt(3, obj.getAccountRole());// ứng với tùng giá trị
            preparedStatement.execute(); /// lưu
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Categories> findAll() throws SQLException,ClassNotFoundException{
        List<Categories> listObj = new ArrayList<>();

        Connection connection = ConnectionHelper.getConnection();//kết nối
        PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.LIST_CATEGORIES);// truyề câu lệnh vào
//        System.out.printf(SQLConfig.LIST_PRODUCT);
        ResultSet resultSet = preparedStatement.executeQuery(SQLConfig.LIST_CATEGORIES); // trả là dữ liệu
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nameCategory = resultSet.getString("nameCategory");
            String photo = resultSet.getString("photo");
            int accountRole  = resultSet.getInt("accountRole");
            Categories obj = new Categories(id,nameCategory,photo,accountRole);
            listObj.add(obj);
        }
        return  listObj;
    }
    public Categories findById(int id) throws SQLException,ClassNotFoundException{
        Categories obj = null;
        Connection connection = ConnectionHelper.getConnection();//kết nối csdl
        PreparedStatement statement =
                connection.prepareStatement(SQLConfig.CATEGORIES_BY_ID,id);// truyền câu lệnh
        statement.setInt(1,id);

        ResultSet resultSet = statement.executeQuery(); // trả ra dữ liệu
        if (resultSet.next()){
            String nameCategory = resultSet.getString("nameCategory");
            String photo = resultSet.getString("photo");
            int accountRole = resultSet.getInt("accountRole");

            obj = new Categories(id,nameCategory,photo,accountRole);
        }
        return  obj;

    }
    public boolean update(int id , Categories updateCategories) throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//kết nối csdl

            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.UPDATE_CATEGORIES); // truyền câu lệnh vào
            preparedStatement.setString(1,updateCategories.getNameCategory());
            preparedStatement.setString(2,updateCategories.getPhoto());
            preparedStatement.setDouble(3,updateCategories.getAccountRole());
            preparedStatement.setInt(4,id);
            preparedStatement.execute();
            return  true;
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  false;
    }
    public boolean delete(int id) throws SQLException,ClassNotFoundException{

        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DELETE_CATEGORIES,id);
            statement.setInt(1,id);
            statement.execute();
            return  true;
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  false;
    }

}
