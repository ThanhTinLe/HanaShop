/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
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
public class SearchController extends HttpServlet {

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

            String proName = request.getParameter("txtSearch");
            String minPrice = request.getParameter("txtMinPrice");
            String maxPrice = request.getParameter("txtMaxPrice");
            String categoryID = request.getParameter("txtCate");

            if (minPrice == null) {
                minPrice = "0";
            }
            if (minPrice.isEmpty()) {
                minPrice = "0";
            }
            if (maxPrice == null) {
                maxPrice = "100";
            }
            if (maxPrice.isEmpty()) {
                maxPrice = "100";
            }
            if (proName == null) {
                proName = "";
            }
            if (categoryID == null) {
                categoryID = "";
            }

            session.setAttribute("PRO_NAME", proName);
            session.setAttribute("MIN_PRICE", minPrice);
            session.setAttribute("MAX_PRICE", maxPrice);
            session.setAttribute("CATEID", categoryID);

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
            if (coutSearch / 15 <= 0) {
                index1 = "0";
            } else {
                index1 = 1 + (coutSearch / 15) + "";
            }
            List<ProductDTO> list = new ArrayList<>();

            List<ProductDTO> listTrue = new ArrayList<>();
            listTrue = dao.GetSearchProductTrue("0", proName, categoryID, minPrice, maxPrice);
            list = dao.GetSearchProduct("0", proName, categoryID, minPrice, maxPrice);

            if (role == null) {
                session.setAttribute("LIST", listTrue);
            } else if (role.equals("true")) {
                session.setAttribute("LIST", listTrue);
            } else {
                session.setAttribute("LIST", list);
            }
            session.setAttribute("INDEX", index1);
            session.setAttribute("CATEID", categoryID);
            request.setAttribute("OKE", "OKE");
            url = SUCCESS;

        } catch (SQLException e) {
            log("SearchCotroller_SQLException: " + e.getMessage());
        } catch (NamingException e) {
            log("SearchCotroller_NamingException: " + e.getMessage());
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
