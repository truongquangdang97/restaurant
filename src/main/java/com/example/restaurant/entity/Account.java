package com.example.restaurant.entity;

import java.time.LocalDateTime;

public class Account {
    private String userName;
    private String fullName;
    private String passwordHash;
    private String salt;
    private String createAt;
    private int errorCount;// số lần thất bại
    private LocalDateTime lockTime;
    private int role;
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    private int status; // 1 là active , 2 là lock

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", salt='" + salt + '\'' +
                ", createAt='" + createAt + '\'' +
                ", errorCount=" + errorCount +
                ", lockTime=" + lockTime +
                ", status=" + status +
                '}';
    }

    public Account(int errorCount, LocalDateTime lockTime, int status) {
        this.errorCount = errorCount;
        this.lockTime = lockTime;
        this.status = status;
    }

    public Account() {
    }

    public Account(String userName, String fullName, String passwordHash, String salt, String createAt, int status) {
        this.userName = userName;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.createAt = createAt;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
