/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.model;


public class book {
    private int book_id;
    private String title;
    private String author;
    private int quantity;
    private String discription;
    
    public book(){}

    public book(int book_id, String title, String author, int quantity, String discription) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.discription = discription;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDiscription() {
        return discription;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    
}
