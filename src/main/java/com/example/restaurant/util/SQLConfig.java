package com.example.restaurant.util;

public class SQLConfig {

    public static final String INSERT_CATEGORIES = "insert into categories(nameCategory,photo) value (?,?)";
    public static final String LIST_CATEGORIES = "select * from categories";
    public static final String  CATEGORIES_BY_ID = "select * from categories where id = ?";
    public static final String UPDATE_CATEGORIES = "update categories set nameCategory = ?, photo = ?, accountRole  = ? where id = ? ";
    public static final String DELETE_CATEGORIES = "delete from categories where id = ? ";

    public static final String INSERT_FOOD = "insert into foods (nameFood, describeFood, photoFood, statusFood , price, categoriesId ) value (?,?,?,?,?,?)" ;
    public static final String DELETE_FOODS = "delete from foods where id = ? ";
    public static final String LIST_FOODS = "select * from foods" ;
    public static final String FOODS_BY_ID = "select * from foods where id = ?";
    public static final String SEARCH = "select * from foods where nameFood like ?";
    public static final String UPDATE_FOODS = "update foods set nameFood = ?, describeFood = ?, photoFood  = ?,statusFood = ?, price = ? ,startTime = ? , updateTime = ? ,categoriesId = ? where id = ? " ;

    public static final String INSERT_ACCOUNT ="insert into accounts (userName,fullName,passwordHash,salt,createAt, status,role) value (?,?,?,?,?,?,?)" ;
    public static final String SELECT_ACCOUNT_BY_USERNAME = "select * from accounts where userName = ? ";
    public static final String LOCK_ACCOUNT = "update accounts set status = ?,errorCount = ?, lockTime = ? where userName = ? ";;
}
