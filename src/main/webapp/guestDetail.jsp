<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.guest.GuestVO" %>

<html>
<head>
    <title>Task</title>
</head>
<body>
<%
    String userId = (String) session.getAttribute("userId");
    GuestVO guest = (GuestVO) request.getAttribute("guest");

    if (guest != null) {
%>
    <h1>상세 페이지</h1>
    <a href="index.jsp">메인</a>
    <a href="guestList?userId=<%= session.getAttribute("userId") %>">목록</a>
<% if (userId != null && !userId.isEmpty() && userId.equals(guest.getGuestId())) { %>
    <a href="guestEditHistory?guestNumber=<%= guest.getGuestNumber() %>">수정</a>
<% } %>
    <p>
        <h3><%= guest.getGuestTitle() %></h3>
        작성자:  <%= guest.getGuestId() %>
        조회수: <%= guest.getGuestHit() %><br>
<%
    String imgFileName = guest.getGuestImgFile();
    if (imgFileName != null && !imgFileName.isEmpty()) {
%>
    <p><img src="img/<%= imgFileName %>" alt="Guest Image"></p>
<%
    }
%>
    <%= guest.getGuestContent() %><br>
    </p>

    <jsp:include page="reply.jsp">
        <jsp:param value="<%= guest.getGuestNumber() %>" name="guestNumber"/>
    </jsp:include>

<%
    if (userId != null && !userId.isEmpty()) {
%>
    <h3>댓글 등록</h3>
    <form action="addComment" method="post">
        <input type="hidden" name="guestNumber" value="<%= guest.getGuestNumber() %>">
        <textarea name="replyContent" rows="4" cols="50" required></textarea><br>
        <input type="submit" value="등록">
    </form>
<%
    } else {
%>
    <p>댓글을 등록하려면 로그인 하세요</p>
<%
    }
%>

<%
    }
%>

</body>
</html>
