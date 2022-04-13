package com.example.restaurant.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Foods {
    private int id ;
    private String nameFood;
    private  String describeFood;
    private  String photoFood;
    private int statusFood;
    private int price;

    private Timestamp startTime;
    private Timestamp updateTime;
    private int categoriesId;

    private HashMap<String, String> error;

    //kiểm tra các trường  có lỗi thì đưa vào hash map
    private void checkValid() {
        this.error = new HashMap<>();
        if (this.nameFood == null || this.nameFood.length() < 7) {
            this.error.put("nameFood", "Không được bỏ trống và nhập ít nhất 7 ký tự .");
        }
        if (this.price==0) {
            this.error.put("price", " Giá phải lớn hơn 0 .");
        }
    }

    public HashMap<String, String> getErrors() {
        checkValid();
        return error;
    }


    public boolean isValid() {
        checkValid();
        return error == null || error.size() == 0;
    }

    public Foods() {
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", nameFood='" + nameFood + '\'' +
                ", describeFood='" + describeFood + '\'' +
                ", photoFood='" + photoFood + '\'' +
                ", statusFood=" + statusFood +
                ", startTime=" + startTime +
                ", updateTime=" + updateTime +
                ", categoriesId=" + categoriesId +
                '}';
    }


    public Foods(String nameFood, String describeFood, String photoFood,int statusFood,int price, int categoriesId) {
        this.nameFood = nameFood;
        this.describeFood = describeFood;
        this.photoFood = photoFood;
        this.statusFood = statusFood;
        this.price = price;
        this.categoriesId = categoriesId;
    }

    public Foods(int id, String nameFood, String describeFood, String photoFood, int statusFood,int price, Timestamp startTime, Timestamp updateTime, int categoriesId) {
        this.id = id;
        this.nameFood = nameFood;
        this.describeFood = describeFood;
        this.photoFood = photoFood;
        this.statusFood = statusFood;
        this.price = price;
        this.startTime= startTime;
        this.updateTime = updateTime;
        this.categoriesId = categoriesId;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getDescribeFood() {
        return describeFood;
    }

    public void setDescribeFood(String describeFood) {
        this.describeFood = describeFood;
    }

    public String getPhotoFood() {
        return photoFood;
    }

    public void setPhotoFood(String photoFood) {
        this.photoFood = photoFood;
    }

    public int getStatusFood() {
        return statusFood;
    }

    public void setStatusFood(int statusFood) {
        this.statusFood = statusFood;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }
}
