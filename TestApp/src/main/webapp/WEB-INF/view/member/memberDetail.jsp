<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-02-12
  Time: 오후 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 정보</title>
</head>
<body>
<p>아이디 : ${member.id}</p>
<p>이메일 : ${member.email}</p>
<p>이름 : ${member.name}</p>
<p>가입일 : <tf:formatDateTime value="${member.registerDateTime}" pattern="yyyy-MM-dd HH:mm" /></p>
<form action="delete/${member.id}" method="post">
<input type="submit"  value="삭제">
</form>
</body>
</html>
