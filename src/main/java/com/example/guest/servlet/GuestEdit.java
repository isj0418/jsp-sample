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

@WebServlet("/guestEdit")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class GuestEdit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestEdit(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestEdit(request, response);
    }

    protected void doGuestEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guestNumber = Integer.parseInt(request.getParameter("guestNumber"));
        String guestName = request.getParameter("guestName");
        String guestTitle = request.getParameter("guestTitle");
        String guestContent = request.getParameter("guestContent");

        GuestVO editedGuest = new GuestVO();
        editedGuest.setGuestNumber(guestNumber);
        editedGuest.setGuestName(guestName);
        editedGuest.setGuestTitle(guestTitle);
        editedGuest.setGuestContent(guestContent);

        Part newImagePart = request.getPart("newImage");
        String fileName = "";
        if (newImagePart != null && newImagePart.getSize() > 0) {
            fileName = extractFileName(newImagePart);
            String savePath = getServletContext().getRealPath("/img");
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            newImagePart.write(savePath + File.separator + fileName);
        }

        editedGuest.setGuestImgFile(fileName);

        GuestDAO guestDAO = new GuestDAO();
        guestDAO.updateGuest(editedGuest);

        response.sendRedirect("guestDetail?guestNumber=" + editedGuest.getGuestNumber());
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
