<%-- 
    Document   : shopping
    Created on : Mar 8, 2023, 10:48:06 AM
    Author     : flami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flamingo Pod Store</title>
        <link rel="stylesheet" href="CSS/adminCSS.css"/>
    </head>
    <body>
        <div style="font-family: monospace; font-size: 20px">
            <h1 style="color:#cc66ff; text-align: center" >Welcome to Flamingo Milk Tea</h1>
            <form action="MainController">
                <h2 style="text-align: center"> 
                    Chose your drink:
                    <select name="cmbTea" style="font-size: 20px">
                        <option value="T01-Ice Tea-10">Ice Tea</option>
                        <option value="T02-Pink Tea-60">Pink Tea</option>
                        <option value="T03-Peach Tea-50">Peach Tea</option>
                        <option value="T04-Matcha Tea-30">Matcha Tea</option>
                    </select>
                    <input style="font-size: 20px" type="number" name="quantity" value="1" min="1"/>
                    <input style="font-size: 20px" type="submit" name="action" value="Add to Cart"/>
                    <input style="font-size: 20px" type="submit" name="action" value="View Cart"/>
                </h2>
            </form>
            <%
                String massage = (String) session.getAttribute("SHOPPING_MASSAGE");
                if (massage == null) {
                    massage = "";
                }
            %>
            <h2 style="color: indigo; background-color: cyan; text-align: center" >
                <%= massage%> <br/>
            </h2>            
            <%session.removeAttribute("SHOPPING_MASSAGE");%>
        </div>

        <h2>      
            <a href="login.html" style="color: blueviolet">Back to Login</a>
        </h2>
    </body>
</html>
