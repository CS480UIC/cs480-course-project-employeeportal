package user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;
/**
 * Servlet implementation class showdata
 */
public class showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		if(request.getParameter("ShowList")!=null)
		{
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from workers");  
            out.println("<table border=1 width=20% height=20%>");  
            out.println("<tr><th>Name</th><th>Age</th><th>Email</th><th>WorkerType</th><th>Skill</th><th>SalaryRange</th><th>Review</th><tr>");  
            while (rs.next()) 
            {  
                String n = rs.getString("Name");  
                String nm = rs.getString("Age");  
                String s = rs.getString("Email");
                String W_type = rs.getString("WorkerType");
                String sk = rs.getString("Skill");
                String sr = rs.getString("SalaryRange");
                String r = rs.getString("Reviews");
                
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>"+ W_type
                		+ "</td><td>"+ sk + "</td><td>" + sr + "</td><td>" + r + "</td></tr>" 
                		
                		);   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
           }  
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
