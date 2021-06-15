package com.car;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname1=request.getParameter("fname");
		String lname1=request.getParameter("lname");

		String carnumber=request.getParameter("plate");
		String mob_no1=request.getParameter("mob_no");
		String email1=request.getParameter("email");
		String city1=request.getParameter("city");
		String pincode1=request.getParameter("pincode");
		String price=request.getParameter("vehicles");
		String payment=request.getParameter("payment");
		int p=Integer.parseInt(price);
		int Max_park=50;
		int count=0;
		
		
		PrintWriter out=response.getWriter();
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?serverTimezone=UTC","root","");
		
		String s="Select * from cust";
		Statement stmt1=con.createStatement();
		ResultSet rs,rs1;
		rs=stmt1.executeQuery(s);
		while(rs.next())
		{
			count++;
		}
		if(count<Max_park)
		{
			String str="INSERT INTO cust " + " (fname,lname,carnumber,mob_no,email,city,pincode,price,payment) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(str);
			
			stmt.setString(1,fname1);
			stmt.setString(2,lname1);
			stmt.setString(3,carnumber);
			stmt.setString(4,mob_no1);
			stmt.setString(5,email1);
			stmt.setString(6,city1);
			stmt.setString(7,pincode1);
			stmt.setInt(8,p);
			stmt.setString(9,payment);
			int c=stmt.executeUpdate();
	        
			
			if(c==1){
			
		
			try{
			String s2="SELECT * from cust where carnumber=?";
				PreparedStatement stmt2=con.prepareStatement(s2);
				stmt2.setString(1, carnumber);
					rs1=stmt2.executeQuery();
					HttpSession session=request.getSession();
					int num;
					String fn,ln,Carnum,mob,emai,ci,pin;
					while(rs1.next())
					{
						num=rs1.getInt(1);
						session.setAttribute("number", num);
						fn=rs1.getString(2);
						session.setAttribute("fn", fn);
						ln=rs1.getString(3);
						session.setAttribute("ln", ln);
						Carnum=rs1.getString(4);
						session.setAttribute("Carnum", Carnum);
						mob=rs1.getString(5);
						session.setAttribute("mob", mob);
						emai=rs1.getString(6);
						session.setAttribute("emai", emai);
						ci=rs1.getString(7);
						session.setAttribute("ci",ci);
						pin=rs1.getString(8);
						session.setAttribute("pin",pin);
						
					}
					response.sendRedirect("my-account.jsp");
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			else
			{
		
				response.sendRedirect("Error.html");

			}
		}
		else
		{
			out.println("<button color='yellow' autofocus padding='50px 32px'><a href='carpark.html'>Back</a></button>");
			out.println("<button color='red' autofocus padding='50px 32px'><a href='index.html'>Home</a></button>");
			out.println("<html><body background='images/gallery/25.jpg'  ><center><br><br><br><br><br><br><br><br><br><br><font color='white' size='15' face='helvetica bold' >Sorry car parking is full..</font></center></body></html>");
		}
		
		con.close();
		
		}catch(SQLException e)
	{
			out.println("<button color='red' autofocus padding='50px 32px'><a href='index.html'>Home</a></button>");
			
			out.println("<button color='blue' autofocus padding='50px 32px'><a href='carpark.html'>Back</a></button>");
		out.println("<html><body background='images/gallery/26.jpg'><center><br><br><br><br><br><br><br><br><font color='white' size='15'>Sorry this car is already parked..</font><center></body></html>");
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
