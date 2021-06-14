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

/**
 *
 * @author Ray Khum
 */
public class MainController extends HttpServlet {

    public static final String ERROR = "error.jsp";
    public static final String LOGIN = "LoginController";
    public static final String LOGOUT = "LogoutController";
    public static final String LOGIN_PAGE = "login.jsp";
    public static final String HOME_PAGE = "home.jsp";
    public static final String SEARCH_PAGE = "search.jsp";
    public static final String SEARCH = "SearchController";
    public static final String SEARCH_PAGING = "SearchPagingController";
    public static final String CREATE_PAGE = "create.jsp";
    public static final String CREATE = "CreateController";
    public static final String PAGING = "PagingController";
    public static final String DELETE = "DeleteController";
    public static final String DELETE_PRODUCT = "DeleteProController";
    public static final String UPDATE_PAGE = "UpdatePageController";
    public static final String UPDATE = "UpdateController";
    public static final String ADD_TO_CART = "AddToCartController";
    public static final String CART_PAGE = "cart.jsp";
    public static final String UPDATE_CART = "UpdateCartController";
    public static final String DELETE_CART = "DeleteCartController";
    public static final String CHECK_OUT = "CheckOutController";
    public static final String HISTORY = "HistoryController";

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
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            }
            if (action.equals("Logout")) {
                url = LOGOUT;
            }
            if (action.equals("Login page")) {
                url = LOGIN_PAGE;
            }
            if (action.equals("Search page")) {
                url = SEARCH_PAGE;
            }
            if (action.equals("Home page")) {
                url = HOME_PAGE;
            }
            if (action.equals("Create Page")) {
                url = CREATE_PAGE;
            }
            if (action.equals("Create")) {
                url = CREATE;
            }
            if (action.equals("Paging")) {
                url = PAGING;
            }
            if (action.equals("Search")) {
                url = SEARCH;
            }
            if (action.equals("Delete Page")) {
                url = DELETE;
            }
            if (action.equals("Delete")) {
                url = DELETE_PRODUCT;
            }
            if (action.equals("Update Page")) {
                url = UPDATE_PAGE;
            }
            if (action.equals("Update")) {
                url = UPDATE;
            }
            if (action.equals("Search Paging")) {
                url = SEARCH_PAGING;
            }
            if (action.equals("AddToCart")) {
                url = ADD_TO_CART;
            }
            if (action.equals("Cart")) {
                url = CART_PAGE;
            }
            if (action.equals("Update Cart")) {
                url = UPDATE_CART;
            }
            if (action.equals("Delete Cart")) {
                url = DELETE_CART;
            }
            if (action.equals("Buy Now")) {
                url = CHECK_OUT;
            }
            if (action.equals("History Page")) {
                url = HISTORY;
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
