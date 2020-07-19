package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;
/**
 * Servlet implementation class CreateDatabase
 */
public class CreateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		UserDao user = new UserDao();
	
		
		try
		{
			
			if(request.getParameter("done")!=null)
			{
				
				UserService userservice = new UserService();
				Map<String,String[]> paramMap = request.getParameterMap();
				User form = new User();
				List<String> info = new ArrayList<String>();
				
				for(String name : paramMap.keySet()) {
					
					String[] values = paramMap.get(name);
					info.add(values[0]);
					System.out.println(name + ": " + Arrays.toString(values));
				}
				form.setUsername(info.get(1));
				form.setPassword(info.get(2));
			
				try
				{
					if(form.getUsername()!=null)

					{
						if(userservice.login(form)==0)
						{
							System.out.println("login successfully");
						
							request.getRequestDispatcher("/jsps/Clientdetails.jsp").forward(request,response);
						}
						else 
						{
							if(userservice.login_worker(form)==1)
							{
								System.out.println("login successfully");
								
								request.getRequestDispatcher("/jsps/Clientdetails.jsp").forward(request,response);
							}
						}
					}
					
				}
				
				
				catch(Exception e)
				{
					e.getStackTrace();
				}
				/*
				 * System.out.println((user.findByUsername(request.getParameter("email"))));
				 * form = user.findByUsername(request.getParameter("email"));
				 */
			//	request.getRequestDispatcher("/jsps/Init.jsp").forward(request,response);		

		}
	}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
