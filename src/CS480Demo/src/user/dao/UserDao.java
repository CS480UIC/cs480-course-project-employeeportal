package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class UserDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public User findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection connect = DriverManager
//			          .getConnection("jdbc:mysql://141.217.48.128:3306/dataview?"
//				              + "user=shiyong&password=view1234");
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employeeportal?"
					+ "user=root&password=modi9akhil");
		    String sql = "select * from workers where WorkerID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		user.setUsername(resultSet.getString("username"));
		    		user.setPassword(resultSet.getString("password"));
		    		user.setEmail(resultSet.getString("email"));
		    		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void add(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection connect = DriverManager
//			          .getConnection("jdbc:mysql://141.217.48.128:3306/dataview?"
//				              + "user=shiyong&password=view1234");
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employeeportal?"
					+ "user=root&password=modi9akhil");
			
			
			String sql = "insert into workers values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    preparestatement.setString(4,"dd");
		    preparestatement.setString(5,"dd");
		    preparestatement.setString(6,"dd");
		    preparestatement.setString(7,"dd");
		    preparestatement.setString(8,"dd");
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			Connection connect = DriverManager
//			          .getConnection("jdbc:mysql://141.217.48.128:3306/dataview?"
//				              + "user=shiyong&password=view1234");
			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employeeportal?"
					+ "user=root&password=modi9akhil");
			
			
			String sql = "select * from workers";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				User user = new User();
				user.setUsername(resultSet.getString("username"));
	    		user.setPassword(resultSet.getString("password"));
	    		user.setEmail(resultSet.getString("email"));
	    		list.add(user);
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
}
