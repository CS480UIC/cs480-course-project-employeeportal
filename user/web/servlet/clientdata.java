package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.domain.User;
import user.domain.client;
import user.service.UserService;

/**
 * Servlet implementation class clientdata
 */
public class clientdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientdata() {
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
		// TODO Auto-generated meStringtub
		UserDao user = new UserDao();
		Map<String,String[]> paramMap = request.getParameterMap();//(return the object of map)
		client form = new client();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) { //keyset contains the keys of specified map here paramMap (which is taking input from
			//our createclientaccount so its column name is our key and value will paramMap.keyset)
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setemail(info.get(0));
		form.setCompany(info.get(1));
		form.setBackground(info.get(2));		
		form.setRequiredWorkertype(info.get(3));
		form.setSalaryafforded(info.get(4));
		form.setNoofdays(info.get(5));
		form.setWorkload(info.get(6));
			try {
				if(user.add_client_details(form)==1)
				{
					request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		doGet(request, response);
	}

}
