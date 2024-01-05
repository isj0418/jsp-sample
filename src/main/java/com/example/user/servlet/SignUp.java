package com.example.user.servlet;

import com.example.user.UserDAO;
import com.example.user.UserVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSignUp(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doSignUp(request, response);
    }

    protected void doSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        String userName = request.getParameter("userName");
        String userPhoneNumber = request.getParameter("userPhoneNumber");

        UserVO userVo = new UserVO();
        userVo.setUserId(userId);
        userVo.setUserPwd(userPwd);
        userVo.setUserName(userName);
        userVo.setUserPhoneNumber(userPhoneNumber);

        UserDAO userDao = new UserDAO();

        if (userDao.signUp(userVo)) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }




    }
}
