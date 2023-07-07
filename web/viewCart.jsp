<%-- 
    Document   : viewCart
    Created on : Mar 8, 2023, 12:06:31 PM
    Author     : flami
--%>

<%@page import="sample.shopping.Tea"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" href="CSS/adminCSS.css"/>
    </head>
    <body>
        <%
            double totalProduct = 0;
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart == null) {
        %>
        <div style="text-align: center; font-size: 20px; font-family: monospace">
            <h1 style="color:#ff6666;" >Your cart is empty!<h1/>
                <h2 style="color:#ff9999;">You should add something to your cart.</h2>
        </div>
        <%
        } else {
        %>
        <div style="text-align: center">
            <table border="1" style="margin: auto; font-size: 25px; font-family: monospace">
                <thead>
                    <tr style="background-color: aqua ">
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                <h1 style="color: darkviolet; font-family: monospace; font-size: 45px; font-weight: bold">Your Cart</h1>
                <%
                    int count = 1;

                    for (Tea tea : cart.getCart().values()) {
                %>
                <form action="MainController">
                    <tr>
                        <td><%= count++%></td>
                        <td>
                            <%= tea.getId()%>
                            <input type="hidden" name="id" value="<%= tea.getId()%>" readonly=""/>
                        </td>
                        <td><%= tea.getName()%></td>
                        <td>
                            <input style="font-size: 25px" type="number" name="quantity" value="<%= tea.getQuantity()%>"
                                   </td>
                        <td><%= tea.getPrice()%></td>
                        <td><%= tea.getPrice() * tea.getQuantity()%></td>
                        <td>
                            <input style="font-size: 25px" type="submit" name="action" value="Update Cart"/>
                            <input type="hidden" name="id" value="<%= tea.getId()%>"/>
                        </td>                        
                        <td>
                            <input style="font-size: 25px" type="submit" name="action" value="Remove"/>
                            <!--<input type="hidden" name="id" value="<%= tea.getId()%>"/>-->
                        </td>
                    </tr> 
                </form>

                <%
                        totalProduct += tea.getPrice() * tea.getQuantity();
                    }
                %>        
                </tbody>
            </table>           
        </div>
        <div style="margin: 20px 0; text-align: center; font-weight: bold">
            <font style="color: maroon; border: 5px solid red; font-size: 25px; " >Total: <%= totalProduct%></font>
        </div>
        <%
            }

        %>
        <h2>            
            <a href="shopping.jsp" style="color: darkgoldenrod;">Back to Shoping Cart</a><br/>
            <a href="login.html">Back to Login</a><br/>
            <a href="checkout.jsp" style="color: #cc66ff;">Check out</a>
        </h2>
    </body>
</html>
