<%-- 
    Document   : createUser
    Created on : Mar 7, 2023, 5:07:53 PM
    Author     : flami
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
        <link rel="stylesheet" href="CSS/adminCSS.css"/>
    </head>
    <body>
        <h1>Create new user</h1>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>
        <form action="MainController" method="POST">
            UserID<input type="text" name="userID" required=""/>
            <%= userError.getUserIDError()%><br/>
            Last Name<input type="text" name="lastName" required=""/>
            <%= userError.getLastNameError()%><br/>
            Role ID<input type="text" name="roleID" required=""/>
            <%= userError.getRoleIDError()%><br/>
            Password<input type="password" name="password" required=""/>
            <%= userError.getPasswordError()%><br/>
            Confirm<input type="password" name="confirm" required=""/>
            <%= userError.getConfirmError()%><br/>
            <input type="submit" name="action" value="Create" required=""/>
            <input type="reset" value="Reset"/>
            <%= userError.getMessageError()%>
        </form>
        <a href="admin.jsp">Back to Login</a>
    </body>
</html>
