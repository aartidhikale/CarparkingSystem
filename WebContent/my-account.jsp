<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
body,h1 {font-family: "Raleway", sans-serif}
body, html {height: 100%}
.bgimg {
  background-image: url('images/gallery/19.jpg');
  min-height: 100%;
  background-position: center;
  background-size: cover;
}
</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
  <div class="w3-display-topleft w3-padding-large w3-xlarge">
   <a href="carpark.html"><button style="color:red;">Back</button></a>
    <a class="dropdown-item" href="index.html" data-toggle="modal" data-target="#logoutModal">
                                  <button > Logout</button>
                                   
                                </a>
  </div>
   <center> <div class="w3-display-middle">
     <h1 class="w3-jumbo w3-animate-top" style="color:black; font-family:helvetica bold;">Car parked Successfully</h1>
      <p class="w3-large w3-center" style="color:red;">Thanks for using Morya parking system....</p>
 <font color="grey"  size="5px">
   <hr class="w3-border-grey" style="margin:auto;width:40%"><br>
   <font size=5 style="color:white; font-family:helvetica bold;">Name : 
 <%
 out.print(session.getAttribute("fn"));
 out.print(" ");
 out.print(session.getAttribute("ln"));
 %><br>
 Mobile Number: 
 <%
 out.print(session.getAttribute("mob"));

 %><br>
 Email :
 <%
 out.print(session.getAttribute("emai"));
 %><br>
 City and Pincode :
 <%
 out.print(session.getAttribute("ci"));
 out.print(" ");
 out.print(session.getAttribute("pin"));
 %><br>
Parking Slot :
  <%
  out.print(session.getAttribute("number"));%><br>
  
   </font>
   
   
  </div>
 </center>
</div>

</body>
</html>
