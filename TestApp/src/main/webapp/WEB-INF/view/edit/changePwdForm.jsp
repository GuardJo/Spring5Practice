<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-02-06
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="change.pwd.title"/></title>
</head>
<body>
<form:form modelAttribute="changePwd">
    <p>
        <label><spring:message code="currentPassword"/></label>
        <form:input path="currentPassword"/>
        <form:errors path="currentPassword"/>
    </p>
    <p>
        <label><spring:message code="newPassword"/></label>
        <form:input path="newPassword"/>
        <form:errors path="newPassword"/>
    </p>
    <input type="submit" value="<spring:message code="change.btn"/>"/>
</form:form>
</body>
</html>
