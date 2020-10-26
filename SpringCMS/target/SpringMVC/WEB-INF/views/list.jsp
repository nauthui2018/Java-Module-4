<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: NguyenVanHuong
  Date: 10/23/20
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<% List<Customer> customers = (List<Customer>) request.getAttribute("customers");%>
<html>
<head>
    <title>Greeting</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #555;
        }
    </style>
</head>
<body>
There are ${requestScope.customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.getId()}</td>
            <td>
                <a href="info?id=${customer.getId()}">${customer.getName()}</a>
            </td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
