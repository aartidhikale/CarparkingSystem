<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String email1=request.getParameter("email");
String pass1=request.getParameter("pass");
try{
	if(email1.equals("admin@gmail.com")&& pass1.equals("admin@123"))
	{
		int a=10;
		session.setAttribute("a", a);
		response.sendRedirect("Admindash.jsp");
	}
	else
	{
		response.sendRedirect("404.html");
	}
}
catch(Exception e)
{

}

%>

</body>
</html>