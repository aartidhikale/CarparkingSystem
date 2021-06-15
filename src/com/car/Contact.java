package com.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");

		String subject=request.getParameter("subject");
		String msg=request.getParameter("comments");
		PrintWriter out=response.getWriter();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?serverTimezone=UTC","root","");
			String str="INSERT INTO contact " + " (name,email,subject,msg) values (?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(str);
			
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,subject);
			stmt.setString(4,msg);
			
			int c=stmt.executeUpdate();
	        
			
			if(c==1){
			      
		
				
				out.println("<button color='red' autofocus padding='50px 32px'><a href='index.html'>Home</a></button>");
				out.println("<html><body background='images/gallery/27.jpg'  ><center><br><br><br><br><br><br><br><br><br><br><font color='white' size='15'>Feedback send....<br> Thanks for contacting us....<br>we will back to You soon. </font></center></body></html>");
				}
			else
			{
		
				response.sendRedirect("4041.html");

			}
			
			
		}catch(Exception e)
		{
			response.sendRedirect("4041.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
