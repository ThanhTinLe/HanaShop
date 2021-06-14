/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinlt.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tinlt.daos.ProductDAO;
import tinlt.dtos.ProductDTO;
import tinlt.dtos.ProductErrorDTO;

/**
 *
 * @author Ray Khum
 */
public class CreateController extends HttpServlet {

    public static final String ERROR = "create.jsp";
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
            String proName = request.getParameter("txtName");
            String proPrice = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String description = request.getParameter("txtDescription");
            String proImage = request.getParameter("txtImage");
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            String createDate = request.getParameter("createDate");
            String expiryDate = request.getParameter("expiryDate");
            String categoryID = request.getParameter("txtCate");

            ProductErrorDTO error = new ProductErrorDTO();
            ProductDAO dao = new ProductDAO();

            boolean check = true;

            if (proName.isEmpty()) {
                check = false;
                error.setProNameError("Name is empty");
            }
            if (proPrice.isEmpty()) {
                check = false;
                error.setProPriceError("Price is empty");
            } else if (Float.parseFloat(proPrice) <= 0) {
                check = false;
                error.setProPriceError("price must be greater than or equal 1");
            }
            if (quantity.isEmpty()) {
                check = false;
                error.setQuantityError("Quantity is empty");
            } else if (Integer.parseInt(quantity) <= 0) {
                check = false;
                error.setQuantityError("quantity must be greater than or equal 1");
            }
            if (description.isEmpty()) {
                check = false;
                error.setDescriptionError("description is empty");
            }
            if (proImage.isEmpty()) {
                check = false;
                error.setProImageError("Image Link is empty");
            }
            if (expiryDate.isEmpty()) {
                check = false;
                error.setExpiryDateError("select expiry date, please");
            } else if (expiryDate.compareTo(createDate) <= 0) {
                check = false;
                error.setExpiryDateError("expiry date must > today");
            }

            if (check) {
                int proID = dao.GetProID() + 1;
                ProductDTO dto = new ProductDTO(proID, proName, Float.parseFloat(proPrice), Integer.parseInt(quantity), description, proImage, status, createDate, expiryDate, categoryID);
                if (dao.CreateProduce(dto)) {
                    url = SUCCESS;
                    request.setAttribute("CEARTED", "Create success");
                } else {
                    url = ERROR;
                }
            } else {
                request.setAttribute("CREATE_ERROR", error);
                url = ERROR;
            }
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
