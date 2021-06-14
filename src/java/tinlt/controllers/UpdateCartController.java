/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tinlt.daos.ProductDAO;
import tinlt.dtos.CartDTO;
import tinlt.dtos.ProductDTO;

/**
 *
 * @author Ray Khum
 */
public class UpdateCartController extends HttpServlet {

    public static final String ERROR = "cart.jsp";
    public static final String SUCCESS = "cart.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String quantity = request.getParameter("txtQuantity");
            String proID = request.getParameter("txtProID");
            String userName = (String) session.getAttribute("USERNAME");

            Map<String, ProductDTO> map = (Map<String, ProductDTO>) session.getAttribute("MAP");
            CartDTO cart = null;
            ProductDAO dao = new ProductDAO();
            ProductDTO dto = dao.GetProByID(proID);
            if (dto.getQuantity() >= Integer.parseInt(quantity)) {
                if (map.containsKey(proID)) {
                    map.get(proID).setQuantity(Integer.parseInt(quantity));
                }
                cart = new CartDTO(userName, map);
                session.setAttribute("MAP", map);
                session.setAttribute("CART", cart);
                request.setAttribute("UPDATE_CART", "Update quantity of " + map.get(proID).getProName() + "be come" + map.get(proID).getQuantity());
                url = SUCCESS;
            } else {
                request.setAttribute("UPDATE_CART", "quantity must less than " + dto.getQuantity());
            }

        } catch (Exception e) {
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
