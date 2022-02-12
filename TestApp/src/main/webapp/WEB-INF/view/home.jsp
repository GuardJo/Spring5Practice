<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <form action="members" method="post">
        <button type="submit">회원검색</button>
    </form>
</div>
<c:if test="${empty authInfo}">
    <p>환영합니다</p>
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
</c:if>
<c:if test="${!empty authInfo}">
    <p>${authInfo.name}님, 환영합니다.</p>
    <div>
        <form action="edit/changePassword" method="get">
            <button type="submit"><spring:message code="change.pwd.title"/></button>
        </form>
        <form action="survey" method="get">
            <button type="submit">설문조사</button>
        </form>
        <form action="logout" method="get">
            <button type="submit">로그아웃</button>
        </form>
    </div>
</c:if>
</body>
</html>