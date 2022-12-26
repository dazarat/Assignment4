<html>
<head>
    <title>Login Page</title>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
</head>

<body>

<% boolean isInvalidLogin;
if (request.getAttribute("isInvalidLogin") == null) {
    isInvalidLogin = false;
} else {
    isInvalidLogin = (boolean) request.getAttribute("isInvalidLogin");
}%>

<form action="login" method="post" >
    <h1> Please, enter your login and password.</h1>
    <br/>
    <p><label>Login:</label>
        <input type="text" name="username"/><br/>
    </p>
    <p><label>Password:</label>
        <input type="password" name="password"/><br/><br/>
    </p>

    <% if (isInvalidLogin) { %>
    <p> Login or password is incorrect! Please, try again. </p>
    <% } %>
    <input type="submit" value="Sign in!"/>
</form>
</body>
</html>