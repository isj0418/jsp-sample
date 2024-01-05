package com.example.guestReply.servlet;

import com.example.guestReply.GuestReplyDAO;
import com.example.guestReply.GuestReplyVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addComment")
public class GuestReply extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestReply(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGuestReply(request, response);
    }

    protected void doGuestReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guestNumber = Integer.parseInt(request.getParameter("guestNumber"));
        String replyContent = request.getParameter("replyContent");
        String userId = (String) request.getSession().getAttribute("userId");

        GuestReplyVO reply = new GuestReplyVO();
        reply.setReplyId(userId);
        reply.setReplyContent(replyContent);
        reply.setReplyCode(guestNumber);

        GuestReplyDAO replyDAO = new GuestReplyDAO();
        replyDAO.addReply(reply);

        response.sendRedirect("guestDetail?guestNumber=" + guestNumber);
    }
}
