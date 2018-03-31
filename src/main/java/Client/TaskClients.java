/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.mycompany.DAO.Address_Access;
import com.mycompany.DAO.Database;
import com.mycompany.DAO.Officer_Access;
import com.mycompany.DTO.Task;
import com.mycompany.DAO.Programme_Access;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TaskClients extends HttpServlet {

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
        
//                    int pid   = Integer.parseInt(request.getParameter("programme")),
               int oid   = Integer.parseInt(request.getParameter("officer")) ,
                aid =    Integer.parseInt(request.getParameter("address"));
              
               System.out.println(pid+" "+oid+" "+aid+"--");
             
            String district =  request.getParameter("district"),
                   
                   type =  request.getParameter("type"),
                   description =  request.getParameter("description"),
                   deadline =  request.getParameter("deadline"),
                   setdate =  request.getParameter("setdate"),
                   URI = "http://localhost:8080/API_HACKATHON/Rest/taskService";
        
                     String[] dates = setdate.split("-");
                    setdate=dates[2]+"/"+dates[1]+"/"+dates[0];
                     Date date = null;
         try {
           date = new SimpleDateFormat("dd/MM/yyyy").parse(setdate);
        } catch (ParseException ex) {
            Logger.getLogger(TaskClients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Task cs = new Task();
        try{
	Database db = new Database();
	Connection con = db.getConnection();
        Programme_Access p = new Programme_Access ();
        Address_Access a = new Address_Access ();
        Officer_Access o = new Officer_Access ();
        
     
       
        cs.setPid(p.getProgramme(con, pid));
        cs.setAid(a.getAddress(con, aid));
        cs.setOid(o.getOfficer(con, oid));
       
       
        cs.setVisitType(type);
        cs.setDescription(description);
        cs.setDeadline(deadline);
        cs.setSetDate(setdate);
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
            
            
            response.sendRedirect("tasks.jsp?txt=success");
            
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
