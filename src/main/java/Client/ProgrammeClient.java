/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.mycompany.DAO.Database;
import com.mycompany.DTO.Programme;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author shivangi
 */
public class ProgrammeClient extends HttpServlet {

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
        
    String name= request.getParameter("name"),
            description = request.getParameter("description"),
            myDate = request.getParameter("date"),
            URI = "http://localhost:8080/API_HACKATHON/Rest/programmeService";
        
        String[] dates = myDate.split("-");
        myDate=dates[2]+"/"+dates[1]+"/"+dates[0];
        
        Date date = null;
        try {
           date = new SimpleDateFormat("dd/MM/yyyy").parse(myDate);
        } catch (ParseException ex) {
            Logger.getLogger(ProgrammeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Programme cs = new Programme();
        try
        {
            cs.setDescription(description);
            cs.setLaunchdate(myDate);
            cs.setName(name);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        Client client = ClientBuilder.newClient();
        
            WebTarget webTarget = client.target(URI).path("add");
            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
            Response res = invocationBuilder.post(Entity.entity(cs, MediaType.APPLICATION_JSON));
            
            System.out.println(res.getStatus());
            System.out.println(res.readEntity(String.class));
        
            response.sendRedirect(URI+"/getAll");
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
