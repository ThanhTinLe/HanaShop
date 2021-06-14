/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tinlt.daos.ProductDAO;
import tinlt.dtos.ProductDTO;

/**
 *
 * @author Ray Khum
 */
public class SearchPagingController extends HttpServlet {

    public static final String ERROR = "";
    public static final String SUCCESS = "search.jsp";

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
            String role = (String) session.getAttribute("ROLE");

            String proName = (String) session.getAttribute("PRO_NAME");
            if (proName == null) {
                proName = "";
            }
            String minPrice = (String) session.getAttribute("MIN_PRICE");
            String maxPrice = (String) session.getAttribute("MAX_PRICE");
            String categoryID = (String) session.getAttribute("CATEID");
            if (minPrice.isEmpty()) {
                minPrice = "0";
            }
            if (maxPrice.isEmpty()) {
                maxPrice = "100";
            }

            ProductDAO dao = new ProductDAO();
            String index1 = request.getParameter("txtPaging");

            int coutSearch = 0;
            if (role == null) {
                coutSearch = dao.CountSearchProductTrue(proName, categoryID, minPrice, maxPrice);
            } else if (role.equals("true")) {
                coutSearch = dao.CountSearchProductTrue(proName, categoryID, minPrice, maxPrice);
            } else {
                coutSearch = dao.CountSearchProduct(proName, categoryID, minPrice, maxPrice);
            }
            String index = "0";
            if (coutSearch / 15 <= 0) {
                index = "0";
            } else {
                index = 1 + (coutSearch / 15) + "";
            }

            List<ProductDTO> list = new ArrayList<>();

            List<ProductDTO> listTrue = new ArrayList<>();
            if (index1.equals("0")) {
                listTrue = dao.GetSearchProductTrue("0", proName, categoryID, minPrice, maxPrice);
                list = dao.GetSearchProduct("0", proName, categoryID, minPrice, maxPrice);
            } else {
                listTrue = dao.GetSearchProductTrue(Integer.parseInt(index1) - 1+"", proName, categoryID, minPrice, maxPrice);
                list = dao.GetSearchProduct(Integer.parseInt(index1) - 1+"", proName, categoryID, minPrice, maxPrice);
            }
            if (role == null) {
                session.setAttribute("LIST", listTrue);
            } else if (role.equals("true")) {
                session.setAttribute("LIST", listTrue);
            } else {
                session.setAttribute("LIST", list);
            }
            session.setAttribute("INDEX", index);
            session.setAttribute("CATEID", categoryID);
            request.setAttribute("OKE", "OKE");
            url = SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
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
