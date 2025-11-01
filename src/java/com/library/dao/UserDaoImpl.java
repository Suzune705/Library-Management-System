/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.dao;

import com.library.enums.UserStatus;
import com.library.model.dto.UserProfileDTO;
import com.library.model.entity.User;
import com.library.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.net.http.common.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author hieuchu
 */
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public List<User> getALLUser() {
        List<User> list = new ArrayList<>();
        String sql = "select * from users ";
        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("user_id"));
                u.setFullname(rs.getString("fullname"));
                u.setAccount(rs.getString("account"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setStatus(UserStatus.convertToEnum(rs.getString("status")));
                u.setAvatar(rs.getString("avatar"));
                list.add(u);
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean checkLogin(String username, String pass) {
        String sql = "select * from users where account = ? and password = ? and role = ?";
        String role = "user";
        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUserExistence(String username) {
        String sql = "select * from users where account = ?";

        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addNewUser(String username, String account, String password) {
        String sql = "insert into users(fullname, account, password, role, avatar) values (?, ?, ?, ?, ?)";
        String role = "user";
        String avatar = "ava.jpg";

        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, account);
            ps.setString(3, password);
            ps.setString(4, role);
            ps.setString(5, avatar);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    @Override
    public boolean checkAdminLogin(String username, String pass) {
        String sql = "select * from users where account = ? and password = ? and role = ?";
        String role = "admin";
        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int findUserID(String account) {
        String sql = "select * from users where users.account = ? ";
        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException s) {
            logger.error("Error excecuting{}", s.getMessage(), s);

        }
        return -1;
    }

    @Override
    public User getUser(String account) {
        String sql = "select * from users where account = ? ";
        logger.info("Getting the data of {} account ", account);
        try (
                Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("user_id"));
                u.setFullname(rs.getString("fullname"));
                u.setAccount(rs.getString("account"));
                u.setAvatar(rs.getString("avatar"));
                u.setRole(rs.getString("role"));
                return u;
            }
        } catch (SQLException s) {
            logger.error("Error excecuting{}", s.getMessage(), s);
        }
        return null;
    }

    @Override
    public boolean updateUser(String account, String avatar, String fullName, int userID) {
        String sql = "UPDATE users SET avatar = ?, fullname = ? , account = ?  WHERE user_id = ?";
        logger.info("Updating user -> account: {}, avatar: {}, fullname: {}", account, avatar, fullName);
        try (
            Connection conn = DBConnection.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, avatar);
            ps.setString(2, fullName);
            ps.setString(3, account);
            ps.setInt(4, userID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException s) {
            logger.error("Error updating user (account: {}): {}", account, s.getMessage(), s);
        }
        return false;
    }

    @Override
    public boolean setOnline(String account) {
       String sql = "update users set status = ? where account = ?";
       try(
           Connection conn = DBConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, UserStatus.ACTIVE.getValue());
           ps.setString(2, account);
           int tmp  =  ps.executeUpdate();
           if(tmp > 0) return true ;
       }catch(SQLException s){
           s.printStackTrace();
       }               
         return false ;
    }

    @Override
    public boolean setOfflife(String account) {
       String sql = "update users set status = ? where account = ?";
       try(
           Connection conn = DBConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, UserStatus.INACTIVE.getValue());
           ps.setString(2, account);
           int tmp  =  ps.executeUpdate();
           if(tmp > 0) return true ;
       }catch(SQLException s){
           s.printStackTrace();
       }               
         return false ;
    }
    
  
}
