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
import javax.servlet.http.HttpSession;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author flami
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "LogoutController";
    private static final String SUCCESS = "SearchController";
    private static final String SEARCH_CONTROLLER = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String lastName = request.getParameter("lastName");
            boolean roleID = (request.getParameter("roleID") == null) ? false : true;
            UserDAO dao = new UserDAO();
            UserDTO user = new UserDTO(userID, lastName, roleID, lastName);
            HttpSession session = request.getSession();
            String userIDUpdate = ((UserDTO) session.getAttribute("LOGIN_USER")).getUserID();
            if (!userID.equals(userIDUpdate)) {
                boolean check = dao.updateUser(user);
                if (check) {
                    url = SUCCESS;
                }
            } else {
                url = SEARCH_CONTROLLER;
                session.setAttribute("ERROR_MESSAGE", "User is logining! Do not update!");
            }
        } catch (Exception e) {
            log("Error at UpdateController" + e.toString());
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
