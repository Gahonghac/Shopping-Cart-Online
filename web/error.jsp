<%-- 
    Document   : error
    Created on : Mar 3, 2023, 9:19:57 PM
    Author     : flami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Error: ${sessionScope.ERROR_MESSAGE} </h1> 
        <h2>
            <a href="login.html">Back to Login</a>
        </h2>
    </body>
</html>
