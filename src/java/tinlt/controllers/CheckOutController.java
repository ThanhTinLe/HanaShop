/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tinlt.daos.CartDAO;
import tinlt.daos.ProductDAO;
import tinlt.dtos.CartDTO;
import tinlt.dtos.ProductDTO;

/**
 *
 * @author Ray Khum
 */
public class CheckOutController extends HttpServlet {

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
            CartDAO dao = new CartDAO();
            ProductDAO proDAO = new ProductDAO();
            String userName = (String) session.getAttribute("USERNAME");
            String total = request.getParameter("txtTotal");
            List<ProductDTO> list = proDAO.GetProductTrue(0);
            Map<String, ProductDTO> map = (Map<String, ProductDTO>) session.getAttribute("MAP");
            CartDTO cart = new CartDTO(userName, map);
            
            if(dao.InsertOrderCart(total,userName)){
                for (ProductDTO value : map.values()) {
                    if(dao.InsertOrderDetail(value.getProID(), value.getQuantity(), value.getProPrice() * value.getQuantity())){
                        for (ProductDTO productDTO : list) {
                            if(productDTO.getProID() == value.getProID()){
                                proDAO.SetQuantityProduct(productDTO.getQuantity() - value.getQuantity(), value.getProID());
                            }
                        }
                        list = proDAO.GetProductTrue(0);
                        map = null;
                        cart = new CartDTO(userName, map);
                        session.setAttribute("LIST", list);
                        session.setAttribute("MAP", map);
                        session.setAttribute("CART", cart);
                        url = SUCCESS;
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
