<%--
  Created by IntelliJ IDEA.
  User: NguyenVanHuong
  Date: 10/23/20
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <h3>Selected Condiment(s)</h3>
    <c:forEach var="condiment" items="${requestScope.condiments}" varStatus="loop">
        <p>${loop.index+1}. ${condiment}</p>
    </c:forEach>
    <a href="/condiments">OK</a>
</body>
</html>
