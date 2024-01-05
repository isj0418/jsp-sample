<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.guest.GuestVO" %>

<html>
<head>
    <title>Guest Edit</title>
</head>
<body>
<%
    String userId = (String) session.getAttribute("userId");

    if (userId != null && !userId.isEmpty()) {
        GuestVO guest = (GuestVO) request.getAttribute("guest");

        if (guest != null) {
%>
    <h1>목록</h1>

    <form action="guestEdit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="guestNumber" value="<%= guest.getGuestNumber() %>">

        <label for="guestName">이름: </label>
        <input type="text" id="guestName" name="guestName" value="<%= guest.getGuestName() %>" required><br>

        <label for="guestTitle">제목: </label>
        <input type="text" id="guestTitle" name="guestTitle" value="<%= guest.getGuestTitle() %>" required><br>

        <label for="guestContent">내용: </label>
        <textarea id="guestContent" name="guestContent" required><%= guest.getGuestContent() %></textarea><br>

        <label for="newImage">이미지: </label>
        <input type="file" id="newImage" name="newImage"><%= guest.getGuestImgFile() %><br>

        <input type="submit" value="수정">
    </form>

    <a href="guestList?userId=<%= session.getAttribute("userId") %>">목록</a>
<%
        }
    }
%>

</body>
</html>
