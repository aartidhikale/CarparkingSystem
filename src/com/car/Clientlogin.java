package com.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Clientlogin
 */
@WebServlet("/Clientlogin")
public class Clientlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email1=request.getParameter("email");
		String pass1=request.getParameter("pass");
		
		String str="select * from cust where email=? AND carnumber=?";
			
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?serverTimezone=UTC","root","");
		PreparedStatement stmt=con.prepareStatement(str);
			stmt.setString(1, email1);
			stmt.setString(2, pass1);
		ResultSet rs=stmt.executeQuery();
			
				if(rs.next())
				{
					
out.println("<button color='red' autofocus padding='50px 32px'><a href='index.html'>Home</a></button>");
					
					out.println("<button color='blue' autofocus padding='50px 32px'><a href='index.html'>logout</a></button>");
					out.println("<html><body background='images/gallery/9.jpg'><center><br><br><br><font color='red' size='20'>Welcome to morya parking system</font></center>");
				out.println("<br><br><br><br><br><br><font  size='7' face='Arial' color='white'>");
			out.println("Name : "+rs.getString(2)+' '+rs.getString(3));
			out.println("<br>");
		out.println(" Car park Slot  Number: "+rs.getInt(1));
		out.println("<br>");
		out.println(" Car Number : "+rs.getInt(4));
		out.println("<br>");
	out.println(" Mobile number : "+rs.getString(5));
	out.println("<br>");
	out.println("Email : "+rs.getString(6));
	out.println("<br>");
		out.println(" City and Pincode "+rs.getString(7)+' '+rs.getString(8));
		out.println("<br>");
				out.println("</font></body></html>");
					
					
				}
				else
				{
					out.println("<button color='red' autofocus padding='50px 32px'><a href='index.html'>Home</a></button>");
					
					out.println("<button color='blue' autofocus padding='50px 32px'><a href='carpark.html'>Back</a></button>");
				out.println("<html><body background='images/gallery/10.jpg'><center><br><br><br><br><br><br><br><br><br><br><br><br><font color='grey' face='helvetica' size='15'>Sorry this car is not present in our system either timeslot of parking is over kindly repark it...</font><center></body></html>");
				}
		
			
		}
		catch(Exception e)
		{
			response.sendRedirect("register.html");
		
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
