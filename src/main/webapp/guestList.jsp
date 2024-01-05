<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.guest.GuestVO" %>

<html>
<head>
    <title>Task</title>
</head>
<body>
<%
    String userId = (String) session.getAttribute("userId");
%>
    <h1>목록</h1>
    <span><a href="index.jsp">메인</a></span>
<%
    if (userId != null && !userId.isEmpty()) {
%>
    <span><a href="guestInsert.jsp">등록</a></span>
<%
    }

    if (userId != null && !userId.isEmpty()) {
%>
    <span><%= userId %>님 <a href="logout">로그아웃</a></span>
<%
    } else {
%>
    <span><a href="login.jsp">로그인</a></span>
<%
    }
    List<GuestVO> guestList = (List<GuestVO>) request.getAttribute("guestList");
%>
    <p></p>
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (GuestVO guest : guestList) {
        %>
        <tr style="text-align: center">
            <td><%= guest.getGuestNumber() %></td>
            <td><%= guest.getGuestId() %></td>
            <td><a href="guestDetail?guestNumber=<%= guest.getGuestNumber() %>"><%= guest.getGuestTitle() %></a></td>
            <td><%= guest.getGuestWdate() %></td>
            <td><%= guest.getGuestHit() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table> <p></p>

    <form action="guestList" method="get">
        <select name="searchType">
            <option value="title">제목</option>
            <option value="author">작성자</option>
            <option value="name">이름</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form> <p></p>

    <div style="margin-left: 80px">
<%
    int currentPage = (int) request.getAttribute("currentPage");
    int totalPages = (int) request.getAttribute("totalPages");

    int maxPageDisplay = 5;

    int startPage = Math.max(1, currentPage - maxPageDisplay / 2);
    int endPage = Math.min(startPage + maxPageDisplay - 1, totalPages);

    if (currentPage > 1) {
        String firstUrl = "guestList?page=1";
%>
    <a href="<%= firstUrl %>">◀◀</a>
<%
    }
    if (currentPage > 1) {
        String prevUrl = "guestList?page=" + (currentPage - 1);
%>
    <a href="<%= prevUrl %>">◀</a>
<%
    }
    for (int i = startPage; i <= endPage; i++) {
        String url = "guestList?page=" + i;
%>
<%
    if (i == currentPage) {
%>
    <strong><a href="<%= url %>"><%= i %></a></strong>
<%
} else {
%>
    <a href="<%= url %>"><%= i %></a>
<%
    }
%>
<%
    }

    if (currentPage < totalPages) {
        String nextUrl = "guestList?page=" + (currentPage + 1);
%>
    <a href="<%= nextUrl %>">▶</a>
<%
    }

    if (currentPage < totalPages) {
        String lastUrl = "guestList?page=" + totalPages;
%>
    <a href="<%= lastUrl %>">▶▶</a>
<%
    }
%>
    </div>
</body>
</html>
