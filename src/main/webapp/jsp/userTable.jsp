
<jsp:useBean id="users" type="java.util.List<entity.User>" scope="request"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UserList</title>
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" type="text/css">
    <style>
        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            margin-top: 30px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            cursor: pointer;
        }
    </style>
</head>

<body>
<table id="userTable">
    <caption><h2>List of users</h2></caption>
    <tr>
        <th>Name</th>
        <th>Login</th>
    </tr>
    <c:forEach var="current" items="${users}">
        <tr>
            <td>${current.name}</td>
            <td>${current.login}</td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/menu" class="button" >Go back to menu</a>
</body>
</html>
