<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2021-12-19
  Time: 오후 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<p>
    <spring:message code="register.done" arguments="${formData.name}"/>
</p>
<p><a href="<c:url value='/'/>">[<spring:message code="go.main"/>]</a> </p>
</body>
</html>