/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.library.controller.user;

import com.library.dao.DaoFactory;
import com.library.model.UserProfileDTO;
import com.library.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hieuchu
 */
@WebServlet(name = "Setting", urlPatterns = {"/user/setting"})
public class Setting extends HttpServlet {

    private final UserService userService = new UserService(
            DaoFactory.getUserDao()
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("account") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }

        String account = (String) session.getAttribute("account");
        UserProfileDTO dto = userService.getProfileUserByAccount(account);
        if (dto == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return;
        }
        session.setAttribute("user", dto);
        request.getRequestDispatcher("/WEB-INF/views/user/setting.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
