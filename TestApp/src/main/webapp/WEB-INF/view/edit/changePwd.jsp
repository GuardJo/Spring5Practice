<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dagh1
  Date: 2022-02-06
  Time: 오후 5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="change.pwd.title"/></title>
</head>
<body>
<p>
    <spring:message code="change.pwd.done"/>
</p>
<p>
    <a href="<c:url value="/"/>">
        [<spring:message code="go.main"/>]
    </a>
</p>
</body>
</html>
