<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-01-16
  Time: 오후 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가입 설문</title>
</head>
<body>
<form:form modelAttribute="memberRegistRequest">
    <p>
        <label>선호 OS</label>
        <form:checkboxes path="favoriteOs" items="${memberRegistRequest.favoriteOs}"/>
    </p>
    <p>
        <label>선호 개발 도구</label>
        <form:radiobuttons path="favoriteTools" items="${memberRegistRequest.favoriteTools}"/>
    </p>
</form:form>

</body>
</html>
