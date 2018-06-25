/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gladi
 */
public class User {

    int uid;
    String username;
    String password;
    int role;
    String fullname;
    String email;
    String avatar;
    boolean status;

    public User(int uid, String email) {
        this.uid = uid;
        this.email = email;
    }

    public User(int uid, String username, String password, int role, String fullname, String email, String avatar, boolean status) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.email = email;
        this.avatar = avatar;
        this.status = status;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
