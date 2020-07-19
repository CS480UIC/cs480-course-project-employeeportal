package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class createworkeraccount
 */
public class createworkeraccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createworkeraccount() {
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
		
		UserDao user = new UserDao();
		UserService userservice = new UserService();
		User form = new User();
		Map<String,String[]> paramMap= request.getParameterMap();
		ArrayList<String> info = new ArrayList<String>();
		for(String name : paramMap.keySet())
		{
			String values[] = paramMap.get(name);
			info.add(values[0]);
		}
		form.setUsername(info.get(1));
		form.setPassword(info.get(3));
		form.setEmail(info.get(2));
		
		if(form.getUsername()!=null)
		{
			try {
				userservice.regist1(form);
				request.getRequestDispatcher("/jsps/workerinfo.jsp").forward(request,response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		doGet(request, response);
	}

}
