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

<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <h1>Dictionary</h1>
    <form method="post">
        <input type="text" name="input" placeholder="${input}">
        <input type="submit" value="Translate">
    </form>
    <p>Meaning: ${meaning}</p>
</body>
</html>
