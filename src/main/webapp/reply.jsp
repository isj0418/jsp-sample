<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.guestReply.GuestReplyVO" %>
<%@ page import="com.example.guestReply.GuestReplyDAO"%>

    <h3>댓글</h3>
<%
    GuestReplyDAO guestReplyDAO = new GuestReplyDAO();
    int guestNumber = Integer.parseInt(request.getParameter("guestNumber"));
    List<GuestReplyVO> replies = guestReplyDAO.getRepliesForGuest(guestNumber);

    if (replies != null && !replies.isEmpty()) {
        for (GuestReplyVO reply : replies) {
%>
    <p>
        <%= reply.getReplyId() %> - <%= reply.getReplyContent() %> - <%= reply.getReplyWdate() %>
    </p>
<%
        }
    } else {
%>
    <p>댓글이 없습니다</p>
<%
    }
%>
