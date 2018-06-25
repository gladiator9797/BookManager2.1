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
public class Book {
    int bid;
    String title;
    String author;
    float price;
    String description;
    String image;
    boolean status;

    public Book() {
    }

    public Book(int bid, String title, String author, float price, String description, String image, boolean status) {
        this.bid = bid;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image = image;
        this.status = status;
    }
    
        public Book(int bid, String title, String author, float price, String description, String image) {
        this.bid = bid;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.image = image;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
