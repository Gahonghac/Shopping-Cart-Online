<%-- 
    Document   : user
    Created on : Mar 3, 2023, 10:55:22 PM
    Author     : flami
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="CSS/adminCSS.css"/>
    </head>
    <%
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        if (user == null) {
            return;
        }
    %>
    <body>
        <h1>Hello User role: <%= user.getLastName()%></h1>
    </body>
</html>
