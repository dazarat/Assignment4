<html>

<head>
    <title>Access restricted!</title>
    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" type="text/css">
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
    <h1>Sorry, you are not a registered user! Please, sign in!</h1>
    <br/>
    <a href="${pageContext.request.contextPath}/login" class="button" >Go to authorization page</a>
</body>
</html>