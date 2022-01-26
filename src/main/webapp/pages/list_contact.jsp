<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="common/common-header.jsp"/>
    <title>List Contact</title>
</head>
<body>
<jsp:include page="common/menu.jsp"/>
<jsp:include page="/ContactController"/>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Birth</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col">Organization</th>
            <th scope="col">Position</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${requestScope.contactList}">
            <tr>
                <td>${item.name}</td>
                <td>${item.birth}</td>
                <td>${item.email}</td>
                <td>${item.phone}</td>
                <td>${item.address}</td>
                <td>${item.organization}</td>
                <td>${item.position}</td>
                <td>
                    <a href="../UpdateContact?contactId=${item.id}"><i class="fas fa-edit"></i></a>
                    <a href="../DeleteContact?contactId=${item.id}"><i class="fas fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>

