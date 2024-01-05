<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Task</title>
</head>
<body>
    <h1>새 등록</h1>

    <form action="guestInsert" method="post" enctype="multipart/form-data">
        <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">

        <label for="guestName">이름: </label>
        <input type="text" id="guestName" name="guestName" required><br>

        <label for="guestTitle">제목: </label>
        <input type="text" id="guestTitle" name="guestTitle" required><br>

        <label for="guestContent">내용: </label>
        <textarea id="guestContent" name="guestContent" required></textarea><br>

        <label for="guestImage">이미지: </label>
        <input type="file" id="guestImage" name="guestImage"><br>

        <input type="submit" value="등록">
    </form>

<a href="guestList">목록</a>
</body>
</html>
