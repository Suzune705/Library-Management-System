/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.dao;

import com.library.model.UserManagerDTO;
import java.util.List;

/**
 *
 * @author hieuchu
 */
public interface AdminDao {
    public List<UserManagerDTO> getAllUserInformation();
}
