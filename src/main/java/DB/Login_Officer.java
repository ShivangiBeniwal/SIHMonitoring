/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mycompany.DAO.Database;
import com.mycompany.DTO.Officer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shivangi
 */
public class Login_Officer extends HttpServlet {

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
        
        String emailId = request.getParameter("emailId");
		String pass = request.getParameter("pass");
                
                System.out.println(emailId+"gcg"+pass);

		try {
			Officer oo=new Officer();
                        
		Database db = new Database();
		Connection con = db.getConnection();
                        
               PreparedStatement ps = con.prepareStatement("SELECT OID, PASSWORD from OFFICER where EMAIL_ID = '"+emailId+"'" );
               ResultSet rs = ps.executeQuery();
                        
                        String word = null;
                        int id =0;
			while (rs.next()) {

				word = rs.getString("PASSWORD");
                                id = rs.getInt("OID");
                                System.out.println("<br>password = "+word);
                        }
                        
                        System.out.println("<br>password = "+word);
				if (word!=null&&word.equals(pass)) 
                                { 
					HttpSession session3  = request.getSession(true);  
////                                        out.print(user);
				        session3.setAttribute("OID",id); 
//                                        String rn="sd";
//////				        out.println("admin id"+id);
//				        session3.setAttribute("idx",id); 
//                                        session3.setAttribute("ran" , rn);
//////                                        out.println("ran"+rn);

                                        System.out.println("password matched");
                                       response.sendRedirect("visiting_status.jsp");
                                }
				else {
                                    System.out.println("password did not match");
                                    String txt = "Incorrect username or password";
                                    response.sendRedirect("homePage.jsp?txt="+txt);					
				}
			
			rs.close();
			con.close();
                        
		} catch (Exception e) {
                    System.out.println("error.....<br>"+e);
			System.out.print("oops! some error occured blaaa");
			System.out.println(e);
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
