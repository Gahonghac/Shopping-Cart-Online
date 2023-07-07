/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.contrllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

/**
 *
 * @author flami
 */
public class CreateController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");
            String roleIDCreate = request.getParameter("roleID");
            String confirm = request.getParameter("confirm");
            boolean roleID;
            boolean check = true;
            UserError userError = new UserError();
            if (userID.length() > 10 || userID.length() < 5) {
                userError.setUserIDError("UserID length must be [5,10]");
                check = false;
            }
            if (lastName.length() > 50 || lastName.length() < 5) {
                userError.setLastNameError("Last Name length must be [5,50]");
                check = false;
            }
            if (!roleIDCreate.trim().equals("true") && !roleIDCreate.trim().equals("false")) {
                userError.setRoleIDError("Role ID must be true or false!");
                check = false;
            }
            if (!password.equals(confirm)) {
                userError.setConfirmError("Password and Confirm is not equal!");
                check = false;
            }
            if (check) {
                roleID = roleIDCreate.trim().equals("true") ? true : false;
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, lastName, roleID, password);
                boolean checkDup = dao.checkDuplicate(userID);
                if (checkDup) {
                    userError.setUserIDError("Duplicate userID: " + user.getUserID());
                    request.setAttribute("USER_ERROR", userError);
                } else {
                    boolean checkInsert = dao.insert(user);
                    if (checkInsert) {
                        url = SUCCESS;
                    } else {
                        userError.setMessageError("Can not insert, unknow error !");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
