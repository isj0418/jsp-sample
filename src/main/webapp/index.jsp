<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String userId = (String) session.getAttribute("userId");
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Task</title>
</head>
<body>
    <h1> 메인 페이지 </h1>
    <a href="index.jsp">메인</a>
    <a href="guestList">목록</a>

<% if (userId != null) { %>
    <span><%= userId %>님 <a href="logout">로그아웃</a></span>
<% } else { %>
    <span><a href="login.jsp">로그인</a></span>
    <a href="signUp.jsp">회원가입</a>
<% } %>

</body>
</html>
