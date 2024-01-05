package com.example.guest.servlet;

import com.example.guest.GuestDAO;
import com.example.guest.GuestVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/guestEditHistory")
public class GuestEditHistory extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestEditHistory(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestEditHistory(request, response);
    }

    protected void doGuestEditHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guestNumber = Integer.parseInt(request.getParameter("guestNumber"));

        GuestDAO guestDAO = new GuestDAO();
        GuestVO guestVO = guestDAO.getGuestByNumber(guestNumber);

        request.setAttribute("guest", guestVO);
        request.getRequestDispatcher("guestEdit.jsp").forward(request, response);
    }
}
