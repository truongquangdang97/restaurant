package com.example.restaurant.model;

import com.example.restaurant.entity.Foods;
import com.example.restaurant.util.ConnectionHelper;
import com.example.restaurant.util.SQLConfig;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodModel {
    public boolean save(Foods obj) throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//Kết nốt csdl
            PreparedStatement preparedStatement = /// thực thi câu lệnh truy vấn .
                    connection.prepareStatement(SQLConfig.INSERT_FOOD); /// truy vấn khi truyền vào
            preparedStatement.setString(1, obj.getNameFood());// ứng với tùng giá trị
            preparedStatement.setString(2, obj.getDescribeFood());// ứng với tùng giá trị
            preparedStatement.setString(3, obj.getPhotoFood());// ứng với tùng giá trị
            preparedStatement.setInt(4, obj.getStatusFood());// ứng với tùng giá trị
            preparedStatement.setInt(5, obj.getPrice());// ứng với tùng giá trị
            preparedStatement.setInt(6, obj.getCategoriesId());// ứng với tùng giá trị
            preparedStatement.execute(); /// lưu
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Foods> findAll() throws SQLException,ClassNotFoundException{
        List<Foods> listObj = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();//kết nối
        PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.LIST_FOODS);// truyền câu lệnh vào
        ResultSet resultSet = preparedStatement.executeQuery(SQLConfig.LIST_FOODS); // trả là dữ liệu
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nameFood = resultSet.getString("nameFood");
            String describeFood = resultSet.getString("describeFood");
            String photoFood = resultSet.getString("photoFood");
            int statusFood = resultSet.getInt("statusFood");
            int price = resultSet.getInt("price");
            Timestamp startTime  = resultSet.getTimestamp("startTime");
            Timestamp updateTime  = resultSet.getTimestamp("updateTime");
            int categoriesId  = resultSet.getInt("categoriesId");
            Foods obj = new Foods(id,nameFood,describeFood,photoFood,statusFood,price,startTime,updateTime,categoriesId);
            listObj.add(obj);
        }
        return  listObj;
    }
    public Foods findById(int id) throws SQLException,ClassNotFoundException{
        Foods obj = null;
        Connection connection = ConnectionHelper.getConnection();//kết nối csdl
        PreparedStatement statement =
                connection.prepareStatement(SQLConfig.FOODS_BY_ID,id);// truyền câu lệnh
        statement.setInt(1,id);

        ResultSet resultSet = statement.executeQuery(); // trả ra dữ liệu
        if (resultSet.next()){
            String nameFood = resultSet.getString("nameFood");
            String describeFood = resultSet.getString("describeFood");
            String photoFood = resultSet.getString("photoFood");
            int statusFood = resultSet.getInt("statusFood");
            int price = resultSet.getInt("price");
            Timestamp startTime  = resultSet.getTimestamp("updateTime");
            Timestamp updateTime  = resultSet.getTimestamp("updateTime");
            int categoriesId  = resultSet.getInt("categoriesId");

            obj = new Foods(id,nameFood,describeFood,photoFood,statusFood,price,startTime,updateTime,categoriesId);
        }
        return  obj;

    }
    public boolean update(int id , Foods updateFood) throws SQLException,ClassNotFoundException{
        try{
            Connection connection = ConnectionHelper.getConnection();//kết nối csdl

            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.UPDATE_FOODS); // truyền câu lệnh vào
            preparedStatement.setString(1,updateFood.getNameFood());
            preparedStatement.setString(2,updateFood.getDescribeFood());
            preparedStatement.setString(3,updateFood.getPhotoFood());
            preparedStatement.setInt(4,updateFood.getStatusFood());
            preparedStatement.setInt(5,updateFood.getPrice());
            preparedStatement.setTimestamp(6,updateFood.getStartTime());
            preparedStatement.setTimestamp(7,updateFood.getUpdateTime());
            preparedStatement.setInt(8,updateFood.getCategoriesId());
            preparedStatement.setInt(9,id);
            preparedStatement.execute();
            return  true;
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  false;
    }
    public List<Foods> search(String txt) throws SQLException, ClassNotFoundException {
        List<Foods> list = new ArrayList<>();
        Connection connection = ConnectionHelper.getConnection();

        PreparedStatement statement = connection.prepareStatement(SQLConfig.SEARCH);
        statement.setString(1,"%"+txt+"%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String nameFood = resultSet.getString("nameFood");
            String describeFood = resultSet.getString("describeFood");
            String photoFood = resultSet.getString("photoFood");
            int statusFood = resultSet.getInt("statusFood");
            int price = resultSet.getInt("price");
            Timestamp startTime  = resultSet.getTimestamp("startTime");
            Timestamp updateTime  = resultSet.getTimestamp("updateTime");
            int categoriesId  = resultSet.getInt("categoriesId");
            Foods obj = new Foods(id,nameFood,describeFood,photoFood,statusFood,price,startTime,updateTime,categoriesId);
            list.add(obj);
        }
        return list;
    }

    public boolean delete(int id) throws SQLException,ClassNotFoundException{

        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DELETE_FOODS,id);
            statement.setInt(1,id);
            statement.execute();
            return  true;
        }catch (SQLException | ClassCastException e){
            e.printStackTrace();
        }
        return  false;
    }

}
