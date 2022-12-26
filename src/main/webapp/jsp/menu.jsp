<%@ page import="entity.User"%>

<html>
<head>
  <title>User Logged Successfully</title>
  <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
</head>

<nav class="myMenu">
  <ul>
    <li><a href="${pageContext.request.contextPath}/table">Users</a></li>
    <li><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
  </ul>
</nav>

<body>
<% User currentUser = (User) (session.getAttribute("currentUser"));%>
<h1> Welcome, <%= currentUser.getLogin() %>!</h1>
</body>
</html>
