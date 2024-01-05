package com.example.guest.servlet;

import com.example.guest.GuestDAO;
import com.example.guest.GuestVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/guestList")
public class GuestList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestList(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestList(request, response);
    }

    protected void doGuestList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuestDAO guestDao = new GuestDAO();

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int totalRecordsPerPage = 10;
        int start = (page - 1) * totalRecordsPerPage;

        String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");

        List<GuestVO> guestList;
        int totalGuests;

        if (searchType != null && keyword != null && !keyword.isEmpty()) {
            switch (searchType) {
                case "title":
                    guestList = guestDao.searchByTitle(keyword, start, totalRecordsPerPage);
                    totalGuests = guestDao.getTotalGuestsCountByTitle(keyword);
                    break;
                case "author":
                    guestList = guestDao.searchByAuthor(keyword, start, totalRecordsPerPage);
                    totalGuests = guestDao.getTotalGuestsCountByAuthor(keyword);
                    break;
                case "name":
                    guestList = guestDao.searchByName(keyword, start, totalRecordsPerPage);
                    totalGuests = guestDao.getTotalGuestsCountByName(keyword);
                    break;
                default:
                    guestList = guestDao.getAllGuests(start, totalRecordsPerPage);
                    totalGuests = guestDao.getTotalGuestsCount();
            }
        } else {
            guestList = guestDao.getAllGuests(start, totalRecordsPerPage);
            totalGuests = guestDao.getTotalGuestsCount();
        }

        int totalPages = (int) Math.ceil((double) totalGuests / totalRecordsPerPage);

        request.setAttribute("guestList", guestList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("guestList.jsp").forward(request, response);
    }
}
