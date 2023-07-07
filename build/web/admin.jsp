<%-- 
    Document   : admin
    Created on : Mar 3, 2023, 10:47:06 PM
    Author     : flami
--%>


<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="CSS/adminCSS.css"/>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID()) {
                response.sendRedirect("login.html");
                return;
            }
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Hello Admin: <%=loginUser.getLastName()%></h1> 

        <!--Logout-->
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <!--Search-->
        <form action="MainController" method="POST">
            Search      <input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <!--Print List-->    
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if ((list == null || list.isEmpty()) && !search.equals("")) {
        %>
        <h2>No record!</h2>
        <%
            }
            if (list != null) {
                if (!list.isEmpty()) {
        %>
        <table class="container">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Last Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : list) {
                %>       
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td><%= user.getUserID()%></td>
                    <td>
                        <input type="text" name="lastName" value="<%= user.getLastName()%>"/>
                    </td>
                    <td>
                        <input type="checkbox" name="roleID"  value="true"
                               <%
                                   if (user.getRoleID()) {
                               %>
                               checked="check"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td><%= user.getPassword()%></td>
                    <td> 
                        <a href="MainController?action=Delete&userID=<%= user.getUserID()%>
                           &search=<%= search%>"> Delete </a>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <input type="hidden" name="userID" value="<%= user.getUserID()%>"/>
                        <input type="hidden" name="search" value="<%= search%>"/>
                    </td>
                </tr>                
            </form>

            <%
                }
            %>

        </tbody>
    </table>

    <%
            }
        }
        String error_message = (String) session.getAttribute("ERROR_MESSAGE");
        if (error_message == null) {
            error_message = "";
        }
    %>
    <h2> <%= error_message%> </h2>
    <% session.removeAttribute("ERROR_MESSAGE");%>

    </body>
</html>
