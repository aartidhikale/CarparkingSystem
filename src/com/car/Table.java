package com.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?serverTimezone=UTC","root","");
		
		String s="Select * from cust";
		Statement stmt1=con.createStatement();
		ResultSet rs =stmt1.executeQuery(s);
		out.println("<body background='images/gallery/14.jpg'>");
		out.println("<button color='white' autofocus padding='10px 12px'><a href='Admindash.jsp'>Back</a></button>");
		out.println("<center><font size='20' color='white'>Records in Database </font></center>");
		out.println("<br><br>");
		out.println("<center><table border='1' bgcolor='#AED6F1' width='50%'><tr><th>Fname</th><th>Lname</th><th>Carnumber</th><th>Mob_no</th><th>email</th><th>city</th><th>pincode</th><th>Payment</th></tr>");
		while(rs.next())
		{
		    String fname=rs.getString(1);
		    String lname=rs.getString(2);
		    String Carnumber=rs.getString(3);
		    String mob_no=rs.getString(4);
		    String email=rs.getString(5);
		    String city=rs.getString(6);
		    String pincode=rs.getString(7);
		    String payment=rs.getString(9);
		 
		    
	      out.print("<tr><td>"+fname+"</td><td>"+lname+"</td><td>"+Carnumber+"</td><td>"+mob_no+"</td><td>"+email+"</td><td>"+city+"</td><td>"+pincode+"</td><td>"+payment+"</td></tr>");
	      
	      
		}
		out.println("</table></center>");
		String s1="Select * from contact";
		Statement stmt2=con.createStatement();
		ResultSet rs1 =stmt2.executeQuery(s1);
		out.println("<br>");
		out.println("<center><font size='20' color='white'> Feedback Collected </font></center>");
		out.println("<br><br>");
		out.println("<center><table border='1' bgcolor='grey' width='50%'><tr><th>Name</th><th>Email</th><th>Subject</th><th>Message</th></tr>");
		while(rs1.next())
		{
		    String name=rs1.getString(1);
		    String email=rs1.getString(2);
		    String subject=rs1.getString(3);
		    String msg=rs1.getString(4);
		    
		 
		    
	      out.print("<tr><td>"+name+"</td><td>"+email+"</td><td>"+subject+"</td><td>"+msg+"</td></tr>");
	      
	      
		}
		out.println("</table></center>");
		
	
		}
		catch(Exception e)
		{
			out.println(e);
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
