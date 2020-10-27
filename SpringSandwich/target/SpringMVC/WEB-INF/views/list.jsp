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
    <h2>Sandwich Condiments</h2>
    <form action="/condiments/save" method="post">
        <c:forEach var="condiment" items="${requestScope.condiments}">
            <input type="checkbox" name="condiment" id="${condiment}" value="${condiment}">
            <label for="${condiment}"> ${condiment}</label>
        </c:forEach>
        <br>
        <input type="submit" value="Save" style="margin-top: 10px">
    </form>
</body>
</html>
