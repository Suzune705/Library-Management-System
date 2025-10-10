/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.model;


public class Borrowing {
    private int borrowingID;
    private int userID;
    private int bookID;
    private String borrowDate;
    private String returnDate;
    private String status;
    
    public Borrowing (){}

    public Borrowing(int borrowingID, int userID, int bookID, String borrowDate, String returnDate, String status) {
        this.borrowingID = borrowingID;
        this.userID = userID;
        this.bookID = bookID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getBorrowingID() {
        return borrowingID;
    }

    public int getUserID() {
        return userID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setBorrowingID(int borrowingID) {
        this.borrowingID = borrowingID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
