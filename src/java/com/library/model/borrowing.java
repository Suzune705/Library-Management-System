/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.model;


public class borrowing {
    private int borrowing_id;
    private int user_id;
    private int book_id;
    private String borrow_date;
    private String return_fdate;
    private String status;
    
    public borrowing (){}

    public borrowing(int borrowing_id, int user_id, int book_id, String borrow_date, String return_fdate, String status) {
        this.borrowing_id = borrowing_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.return_fdate = return_fdate;
        this.status = status;
    }

    public int getBorrowing_id() {
        return borrowing_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public String getReturn_fdate() {
        return return_fdate;
    }

    public String getStatus() {
        return status;
    }

    public void setBorrowing_id(int borrowing_id) {
        this.borrowing_id = borrowing_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public void setReturn_fdate(String return_fdate) {
        this.return_fdate = return_fdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
