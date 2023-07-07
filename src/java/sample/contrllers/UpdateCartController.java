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
import sample.shopping.Cart;
import sample.shopping.Tea;

/**
 *
 * @author flami
 */
public class UpdateCartController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    public static final String SUCCESS = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String ID = request.getParameter("id");
            int newQuantity = Integer.parseInt(request.getParameter("quantity"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            
            if (newQuantity <= 0) {
                cart.getCart().remove(ID);
            } else {
                Tea tea = null;
                for (Tea dto : cart.getCart().values()) {
                    if (dto.getId().equals(ID)) {
                        String name = dto.getName();
                        double price = dto.getPrice();
                        tea = new Tea(ID, name, newQuantity, price);
                        break;
                    }
                }
                cart.update(ID, tea);
            }
            if(cart.getCart().size()==0){
                session.removeAttribute("CART");
            }else{
                session.setAttribute("CART", cart);
            }
            
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at UpdateViewCartController: " + e.toString());
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
