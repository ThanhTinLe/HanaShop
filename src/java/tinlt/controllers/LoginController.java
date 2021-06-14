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
import javax.servlet.http.HttpSession;
import tinlt.daos.UserDAO;
import tinlt.dtos.UserDTO;
import tinlt.dtos.UserErrorDTO;

/**
 *
 * @author Ray Khum
 */
public class LoginController extends HttpServlet {

    public static final String ERROR = "login.jsp";
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
            String username = request.getParameter("txtuserName");
            String password = request.getParameter("txtpassword");
            HttpSession session = request.getSession();
            boolean check = true;
            UserDAO dao = new UserDAO();
            UserDTO dto = null;
            UserErrorDTO error = new UserErrorDTO();

            if (username.isEmpty()) {
                error.setUserNameError("user name is empty");
                check = false;
            }
            if (password.isEmpty()) {
                error.setPasswordError("password is empty");
                check = false;
            }

            if (check) {
                if (dao.CheckLogin(username, password) != null) {
                    dto = new UserDTO(username, dao.CheckLogin(username, password).getFullName(), password, dao.CheckLogin(username, password).isRole());
                    if (dto.getFullName() != null) {
                        url = SUCCESS;
                        session.setAttribute("FULLNAME", dto.getFullName());
                        session.setAttribute("USERNAME", username);
                        session.setAttribute("ROLE", dto.isRole() + "");
                    }
                } else {
                    request.setAttribute("MESS", "username or password incorect");
                    url = ERROR;
                }
            } else {
                request.setAttribute("ERROR", error);
                url = ERROR;
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
