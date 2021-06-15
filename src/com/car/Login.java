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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email1=request.getParameter("email");
		String pass1=request.getParameter("pass");
		try{
			if(email1.equals("admin@gmail.com")&& pass1.equals("admin@123"))
			{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?serverTimezone=UTC","root","");
				
				String s="Select price from cust";
				Statement stmt1=con.createStatement();
				ResultSet rs =stmt1.executeQuery(s);
				int total=0;
				int count=0;
				while(rs.next())
				{
					count++;
					total+=rs.getInt("price");
				}
				String totalYear="100000";
				
				String t=String.valueOf(total);
				String cnt=String.valueOf(count);
				HttpSession session=request.getSession();
			    session.setAttribute("count", count);
			    session.setAttribute("total", total);
			    session.setAttribute("totalYear",totalYear);
				response.sendRedirect("Admindash.jsp");
				
			}
			else
			{
				response.sendRedirect("Adminloginfail.html");	
			}
		}
			
		catch(Exception e)
		{
		out.println(e);
		}
		
		
		//String str="select * from customer where email=? AND pass=?";
			
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
