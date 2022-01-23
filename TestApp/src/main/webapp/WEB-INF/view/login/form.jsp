<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-01-15
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<form:form modelAttribute="loginInfo">
    <form:select path="loginType" multiple="single">
        <option value="">---선택하세요---</option>
        <form:options items="${loginInfo.loginType}"/>
    </form:select>
</form:form>
</body>
</html>
