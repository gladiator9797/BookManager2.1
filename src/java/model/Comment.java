/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author gladi
 */
public class Comment {

    int cid;
    int uid;
    int bid;
    String title;
    String username;
    String avatar;
    String comment;
    String createdDate;
    boolean status;
    

    public Comment() {
    }

    public Comment(int cid, int uid, int bid, String title, String username, String avatar, String comment, String createdDate, boolean status) {
        this.cid = cid;
        this.uid = uid;
        this.bid = bid;
        this.title = title;
        this.username = username;
        this.avatar = avatar;
        this.comment = comment;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Comment(int uid, int bid, String title, String username, String avatar, String comment, String createdDate, boolean status) {
        this.uid = uid;
        this.bid = bid;
        this.title = title;
        this.username = username;
        this.avatar = avatar;
        this.comment = comment;
        this.createdDate = createdDate;
        this.status = status;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
