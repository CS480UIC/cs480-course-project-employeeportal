package user.service;

import java.util.List;

import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author changxin bai
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * register a user
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void regist(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByUsername(form);
		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		userDao.add(form);
	}
	
	
	public void regist1(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByUsername_worker(form);
		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		userDao.add1(form);
	}
	
	
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public int login(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByUsername(form);
		if(user.getUsername()==null)
		{
			
		return -1;
		}
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			{
		return -2;
			
		}
		return 0;
	}
	
	//you still have to manage login for workers
	
	public int login_worker(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByUsername_worker(form);
		if(user.getUsername()==null) 
		{
			return -1;
		}
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
		{
			return -1;
		}
		return 1;
	}
	
	
	public void delete(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		
		if(userDao.findByUsername(form)!=null)
		{
			userDao.deleteByUsername(form);
		}
		else if(userDao.findByUsername_worker(form)!=null)
		{
			userDao.delete_worker(form);
		}
		else
		{
			throw new UserException(" The username is not correct");
		}
		
//		
//		String password = user.getPassword();
//		
//		if(password!=null && !password.equals(form.getPassword()))
//			throw new UserException(" The password is not right");		
	}
	
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
}
