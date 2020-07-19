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

import user.domain.User;
import user.service.UserService;

/**
 * Servlet implementation class createaccounts
 */
public class createaccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createaccounts() {
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
		
		UserService userservice = new UserService();
		Map<String,String[]> paramMap = request.getParameterMap();//(return the object of map)
		User form = new User();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) { //keyset contains the keys of specified map here paramMap (which is taking input from
			//our createclientaccount so its column name is our key and value will paramMap.keyset)
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setUsername(info.get(1));
		form.setPassword(info.get(3));
		form.setEmail(info.get(2));
		
		try
		{
			if(form.getUsername()!=null)

			{
				userservice.regist(form);
				System.out.println("Registered successfully");
				request.getRequestDispatcher("/jsps/clientinfo.jsp").forward(request,response);
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
		doGet(request, response);
	}

}
