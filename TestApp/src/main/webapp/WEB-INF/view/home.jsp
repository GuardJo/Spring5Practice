<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Study</title>
</head>
<body>
<h1>Home Page</h1>
<div>
    <form action="hello" method="get">
        <input type="text" name="name">이름 :
        <button type="submit">인사</button>
    </form>
</div>
<div>
    <form action="hello2" method="get">
        <input type="text" name="name">이름 :
        <button type="submit">인사2</button>
    </form>
</div>
<div>
    <form action="register/step1" method="post">
        <button type="submit">회원가입</button>
    </form>
    <form action="survey" method="get">
        <button type="submit">설문조사</button>
    </form>
    <form action="login" method="get">
        <button type="submit">로그인</button>
    </form>
</div>
</body>
</html>