package com.example.guest.servlet;

import com.example.guest.GuestDAO;
import com.example.guest.GuestVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/guestInsert")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class GuestInsert extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestInsert(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestInsert(request, response);
    }

    protected void doGuestInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestName = request.getParameter("guestName");
        String guestTitle = request.getParameter("guestTitle");
        String guestContent = request.getParameter("guestContent");

        GuestVO guestVO = new GuestVO();
        guestVO.setGuestName(guestName);
        guestVO.setGuestTitle(guestTitle);
        guestVO.setGuestContent(guestContent);

        String userId = (String)request.getSession().getAttribute("userId");
        guestVO.setGuestId(userId);

        Part filePart = request.getPart("guestImage");
        String fileName = "";
        if (filePart != null) {
            fileName = extractFileName(filePart);
            String savePath = getServletContext().getRealPath("/img");
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            filePart.write(savePath + File.separator + fileName);
        }

        guestVO.setGuestImgFile(fileName);

        GuestDAO guestDAO = new GuestDAO();
        guestDAO.insertGuest(guestVO);

        response.sendRedirect("/guestList");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
