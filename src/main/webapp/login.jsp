<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task</title>
</head>
<body>
    <h1>로그인</h1>
    <form action="login" method="post">
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" required><br>

        <label for="userPwd">비밀번호:</label>
        <input type="password" id="userPwd" name="userPwd" required><br>

        <input type="submit" value="Login">
    </form>
    <a href="index.jsp">메인</a>
    <a href="signUp.jsp">회원가입</a>
</body>
</html>
