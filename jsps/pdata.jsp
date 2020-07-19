<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

<form method="post">

<table border="2">
   <tr>
        <td>Name</td>
        <td>Age</td>
        <td>Email</td>
        <td>WorkerType</td>
        <td>Skill</td>
        <td>SalaryRange</td>
        <td>Reviews</td>
   </tr>
   <%
   try
   {
	   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		Connection conn= DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
		
				String query = "Select * from workers";
       Statement stmt=conn.createStatement();
       ResultSet rs=stmt.executeQuery(query);
       while(rs.next())
       {
   %>    
   	   <tr><td><%out.println(rs.getString("Name")); %></td>
       <td><%out.println(rs.getString("Age")); %></td>
       <td><%out.println(rs.getString("Email")); %></td>
       <td><%out.println(rs.getString("WorkerType")); %></td>
       <td><%out.println(rs.getString("Skill")); %></td>
       <td><%out.println(rs.getString("SalaryRange")); %></td>
       <td><%out.println(rs.getString("Reviews")); %></td>
</tr>
	
   <%
       }
   %>
   </table>
   <%
        rs.close();
        stmt.close();
        conn.close();
   }
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</form>`