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
    <title>Convertor</title>
</head>
<body>
    <h1>Convertor</h1>
    <form action="/convertor" method="post">
        <p>From</p>
        <input type="text" name="input">
        <select name="from">
            <option value="vnd">VND</option>
        </select>
        <p>To</p>
        <select name="to">
            <option value="vnd">VND</option>
            <option value="usd">USD</option>
            <option value="cad">CAD</option>
            <option value="aud">AUD</option>
        </select>
        <br><br>
        <input type="submit" value="Convert">
        <p>Result: ${requestScope["result"]}</p>
    </form>
</body>
</html>
