<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="signUp" method="post">
        <label for="userId">아이디: </label>
        <input type="text" id="userId" name="userId" required><br>

        <label for="userPwd">비밀번호::</label>
        <input type="password" id="userPwd" name="userPwd" required><br>

        <label for="userName">이름: </label>
        <input type="text" id="userName" name="userName" required><br>

        <label for="userPhoneNumber">휴대전화: </label>
        <input type="text" id="userPhoneNumber" name="userPhoneNumber" required><br>

        <input type="submit" value="회원가입">
        <input type="reset" value="지우기">
    </form>
    <a href="index.jsp">메인</a>
</body>
</html>
