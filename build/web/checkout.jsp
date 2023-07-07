<%-- 
    Document   : checkout
    Created on : Mar 8, 2023, 14:01:52 PM
    Author     : flami
--%>

<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <h1 style="color: red; text-align: center">Check Out Failed</h1>
        <h2 style="text-align: center" >You did not chosen any thing</h2>
        <a href="shopping.jsp" style="color: green; font-size: 20px">Click here to continue order !</a>
        <%
        } else {
        %>               
        <h1 style="text-align: center; color: #cc66ff">Check Out Successfully!</h1>
        <h2 style="text-align: center" >Thank for your shoppiong !!!</h2>
        <h2 style="text-align: center" >Have a nice day !!!</h2>
        <a href="shopping.jsp" style="color: green; font-size: 20px">Click here to continue order !</a>
        <%
            session.removeAttribute("CART");
            }
        %>
    </body>
</html>
