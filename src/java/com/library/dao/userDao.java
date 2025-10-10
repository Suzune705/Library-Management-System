/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.dao;

import com.library.model.User;
import java.sql.*;


public class userDao {

    private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=Library_Management_System;encrypt=false";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "123456789";

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
