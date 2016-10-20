/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Manage;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gines
 */
public class DbServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
        } finally {
            out.close();
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
        try {
            ArrayList<Alumnes> alumnes = new ArrayList<Alumnes>();
            String url = "jdbc:mysql://localhost:3306/javatest_01";
            String usr = "java_admin";
            String pwd = "123456789";
            MySQLConnection mysql = new MySQLConnection(url, usr, pwd);
            Connection conn = mysql.getConnection();
            DbDataHandler dbHandler = new DbDataHandler();
            alumnes = dbHandler.getAlumnesList(conn);
            Gson gson = new Gson();
            JsonElement jsonElmnt;
            JsonArray jsonArr;
            jsonElmnt = gson.toJsonTree(alumnes);
            jsonArr = jsonElmnt.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArr);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            String code = request.getParameter("code");
            String url = "jdbc:mysql://localhost:3306/javatest_01";
            String usr = "java_admin";
            String pwd = "123456789";
            MySQLConnection mysql = new MySQLConnection(url, usr, pwd);
            Connection conn = mysql.getConnection();
            ArrayList<Alumnes> alumnes = new ArrayList<Alumnes>();
            DbDataHandler dbHandler = new DbDataHandler();
            alumnes = dbHandler.getAlumneInfo(conn, Integer.parseInt(code));
            System.out.println(alumnes.get(0).getAssignatures());
            Gson gson = new Gson();
            JsonElement jsonElmnt;
            JsonArray jsonArr;
            jsonElmnt = gson.toJsonTree(alumnes);
            jsonArr = jsonElmnt.getAsJsonArray();
            response.setContentType("application/json");
            response.getWriter().print(jsonArr);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
