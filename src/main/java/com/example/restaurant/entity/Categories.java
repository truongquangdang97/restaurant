package com.example.restaurant.entity;

import java.util.HashMap;

public class Categories {
    private int id;
    private String nameCategory;
    private String photo;
    private int accountRole;

    private HashMap<String, String> error;

    //kiểm tra các trường  có lỗi thì đưa vào hash map
    private void checkValid() {
        this.error = new HashMap<>();
        if (this.nameCategory == null || this.nameCategory.length() < 7) {
            this.error.put("nameCategory", "Không được bỏ trống và nhập ít nhất 7 ký tự .");
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

    @Override
    public String toString() {
        return "categories{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                ", photo='" + photo + '\'' +
                ", accountRole=" + accountRole +
                '}';
    }

    public Categories() {
    }

    public Categories(String nameCategory, String photo) {
        this.nameCategory = nameCategory;
        this.photo = photo;
    }

    public Categories(String nameCategory, String photo, int accountRole) {
        this.nameCategory = nameCategory;
        this.photo = photo;
        this.accountRole = accountRole;
    }

    public Categories(int id, String nameCategory, String photo, int accountRole) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.photo = photo;
        this.accountRole = accountRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(int accountRole) {
        this.accountRole = accountRole;
    }
}
