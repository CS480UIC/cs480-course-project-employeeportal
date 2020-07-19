package user.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import user.domain.client;
import user.domain.worker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Random; 

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
	public int clientid;

	public User findByUsername(User form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
		    String sql = "select * from clientcredentials where ClientLoginID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(form.getUsername());
		    preparestatement.setString(1,form.getUsername());		
		    
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("ClientLoginID");   	
		    	if(user_name.equals(form.getUsername())){
		    		user.setUsername(resultSet.getString("ClientLoginID"));
		    		user.setPassword(resultSet.getString("ClientPassword"));
		    		 		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	
	public User deleteByUsername(User form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//working properly for client 
		//so at this point we are done 
		//1-) Inserting, deleting in both our second and third entity 
		// 2-) also done inserting, deleting, reading our first entity
		User user = new User();
		try {
			//this is basically deletion of client
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
			String email = form.getEmail();
			String sql2 = "SELECT * from clientcredentials Where ClientloginID=? AND Clientpassword=?";	
	    	PreparedStatement pstmt1 = connect.prepareStatement(sql2);

			pstmt1.setString(1,form.getUsername());
	    	pstmt1.setString(2,form.getPassword());		
	    	ResultSet resultSet = pstmt1.executeQuery();
//	    	String clients_id = resultSet.getString("ClientloginID");
	    	String the_id= "";
	    	while(resultSet.next())
	    	{
	    		//doing this so that i can delete the related data from other entities
	    	
	    			user.setEmail(resultSet.getString("Email"));			

	    	}
	    	//once you get the clientlogin ID
				////////////this is deleting from entity 1///////
		    String sql = "DELETE  FROM clientcredentials where ClientloginID=? AND Clientpassword=?" ;
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    	PreparedStatement pstmt = connect.prepareStatement(sql);
		    	pstmt.setString(1,form.getUsername());
		    	pstmt.setString(2,form.getPassword());		    	
		    	pstmt.executeUpdate();
		    	///////////////////////
			String sql1 = "DELETE FROM clients where Email=?" ;
			PreparedStatement pstmt2 = connect.prepareStatement(sql1);
				pstmt2.setString(1,user.getEmail() );
		    	pstmt2.executeUpdate();

		    	System.out.println("deleted");
		    
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	///////////find by username for worker/////////
	
	public User findByUsername_worker(User form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
		    String sql = "select * from workercredentials where WorkerLoginID=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    System.out.println(form.getUsername());
		    preparestatement.setString(1,form.getUsername());		
		    
		    ResultSet resultSet = preparestatement.executeQuery();
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    while(resultSet.next()){
		    	String user_name = resultSet.getString("WorkerLoginID");   	
		    	if(user_name.equals(form.getUsername())){
		    		user.setUsername(resultSet.getString("WorkerLoginID"));
		    		user.setPassword(resultSet.getString("WorkerPassword"));
		    		 		
		    	}
		    }
		
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
	
	
	public User delete_worker(User form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = new User();
		//this one is to delete workers
		try {
			//this is basically deletion of client
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
			String email = form.getEmail();
			String sql2 = "SELECT * from workercredentials Where WorkerLoginID=? AND WorkerPassword=?";	
	    	PreparedStatement pstmt1 = connect.prepareStatement(sql2);

			pstmt1.setString(1,form.getUsername());
	    	pstmt1.setString(2,form.getPassword());		
	    	ResultSet resultSet = pstmt1.executeQuery();
	    	String the_id= "";
	    	while(resultSet.next())
	    	{
	    		//doing this so that i can delete the related data from other entities
	    	
	    			user.setEmail(resultSet.getString("Email"));			

	    	}
	    	//once you get the clientlogin ID
				////////////this is deleting from entity 1///////
		    String sql = "DELETE  FROM workercredentials where WorkerLoginID=? AND WorkerPassword=?" ;
		    //ResultSet resultSet  = preparestatement.executeUpdate();
		    	PreparedStatement pstmt = connect.prepareStatement(sql);
		    	pstmt.setString(1,form.getUsername());
		    	pstmt.setString(2,form.getPassword());		    	
		    	pstmt.executeUpdate();
		    	///////////////////////
			String sql1 = "DELETE FROM workers where Email=?" ;
			PreparedStatement pstmt2 = connect.prepareStatement(sql1);
				pstmt2.setString(1,user.getEmail() );
		    	pstmt2.executeUpdate();

		    	System.out.println("deleted");

		
		    
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
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
			
			String sql = "insert into clientcredentials values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    Random rand = new Random();
	        int rand1 = rand.nextInt(1000); 
	        clientid = rand1;
		    preparestatement.setString(4, Integer.toString(rand1)); //parsing integer to string
		       
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int add_client_details(client client) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");		
			
			
			String sql = "insert into clients values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,client.getemail());
		    preparestatement.setString(2,client.getCompany());
		    preparestatement.setString(3,client.getBackground());
		    preparestatement.setString(4,client.getRequiredWorkertype());
		    preparestatement.setString(5,client.getSalaryafforded());
		    preparestatement.setString(6,client.getNoofdays());
		    preparestatement.setString(7,client.getWorkload());
System.out.println("printing"+ client.getemail());
		    preparestatement.executeUpdate();
	
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}
	
	public void add1(User user) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
			
			String sql = "insert into workercredentials values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,user.getUsername());
		    preparestatement.setString(2,user.getPassword());
		    preparestatement.setString(3,user.getEmail());
		    Random rand = new Random();
	        int rand1 = rand.nextInt(1000); 
		    preparestatement.setString(4, Integer.toString(rand1)); //parsing integer to string
		       
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void add_worker_details(worker worker) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");		
			
			
			String sql = "insert into workers values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			 Random rand = new Random();
				int rand1 = rand.nextInt(1000); 
		        clientid = rand1;
			preparestatement.setString(1, Integer.toString(rand1));
			preparestatement.setString(2,worker.getName());
		    preparestatement.setString(3,Integer.toString(worker.getAge()));
		    preparestatement.setString(4,worker.getEmail());
		    preparestatement.setString(5,worker.getWorkerType());
		    preparestatement.setString(6,worker.getSkill());
		    preparestatement.setString(7,worker.getSalaryRange());
		    preparestatement.setString(8,Integer.toString(worker.getReviews()));
		    
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update_worker_details(worker worker) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");		
			
			
			String sql = "update workers set SalaryRange = ? where Email = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,worker.getSalaryRange());
		    preparestatement.setString(2,worker.getEmail());   
		    preparestatement.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public void update_client_requirement(client worker) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			//okay here i'm updating two entities at the same time
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");		
			
			
			String sql = "update clients set Email = ? where Email = ?";	
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    String store_prevemail = worker.getemail();
			String store_newemail = worker.getCompany();
		    preparestatement.setString(1,worker.getemail());
		    preparestatement.setString(2,worker.getCompany());
		    preparestatement.executeUpdate();


			String sql1 = "update clientcredentials set Email = ? where Email = ?";	
			PreparedStatement preparestatement1 = connect.prepareStatement(sql1); 

			preparestatement1.setString(1,worker.getemail());
			    preparestatement1.setString(2,worker.getCompany());
			    preparestatement1.executeUpdate();

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");
			
			String sql = "select * from clients";
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
	public void createtable() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 //Getting the connection
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/employeeportal","root","Oolong123!@#");

		      System.out.println("Connection established......");
		      //Initialize the script runner
		      	Statement statement = connect.createStatement();
		      statement.executeLargeUpdate("DROP TABLE IF EXISTS portal_managers");
			   statement.executeLargeUpdate("DROP TABLE IF EXISTS Workers");
			   statement.executeLargeUpdate("DROP TABLE IF EXISTS Clients");
			   
			   String table1 = "CREATE TABLE IF NOT EXISTS portal_managers " +
					   "(ClientID INTEGER not null, " + 
					   "ClientLoginID VARCHAR(50) not null, " + 
					   "ClientPassword VARCHAR(50) not null, " + 
					   "WorkerID INTEGER not null, " + 
					   "WorkerLoginID VARCHAR(50) not null, " + 
					   "WorkerPassword VARCHAR(50) not null, " + 
					   "primary key(ClientID, WorkerID));";
			   statement.executeLargeUpdate(table1);
			   

			   String populateTable1 = "insert into portal_managers values (0001, 'Company1', 'company1', 0001, 'Worker1', 'worker1');"; 
			   String populateTable1a = "insert into portal_managers values (0002, 'Company2', 'company2', 0002, 'Worker2', 'worker2');"; 
			   String populateTable1b = "insert into portal_managers values (0003, 'Company3', 'company3', 0003, 'Worker3', 'worker3');";
			   statement.executeLargeUpdate(populateTable1);
			   statement.executeLargeUpdate(populateTable1a);
			   statement.executeLargeUpdate(populateTable1b);
			   
			   
			   String table2 = "CREATE TABLE IF NOT EXISTS Workers(" + 
			   		"	WorkerID INTEGER(20) primary key, " + 
			   		"	Name VARCHAR(50) not null, " + 
			   		"	Age INTEGER(10), " + 
			   		"	Email VARCHAR(50) not null, " + 
			   		"	WorkerType VARCHAR(50) not null, " + 
			   		"	Skill VARCHAR(50) not null, " + 
			   		"	SalaryRange INTEGER(20), " + 
			   		"	Reviews VARCHAR(500)" + 
			   		");";
			   statement.executeLargeUpdate(table2);
			   
			   String populateTable2 = "insert into workers values (0001, 'John', 36, 'john@gmail.com', 'IT Worker', 'Technician', null, null);";
			   String populateTable2a = "insert into workers values (0002, 'Mark', 30, 'mark@yahoo.com', 'Chef', 'Food', 2000, 3.7);";
			   String populateTable2b = "insert into workers values (0003, 'Sam', 33, 'sam@aol.com', 'Mechanic', 'Car Repairs', 2500, 3.2);";
			   statement.executeLargeUpdate(populateTable2);
			   statement.executeLargeUpdate(populateTable2a);
			   statement.executeLargeUpdate(populateTable2b);
			   
			   
			   String table3 = "CREATE TABLE IF NOT EXISTS Clients( " + 
			   		"	ClientID int(20) primary key," + 
			   		"	Name varchar(50) not null," + 
			   		"	Background varchar(50) not null," + 
			   		"	RequiredWorkerType varchar(50)," + 
			   		"	SalaryAfforded int(20)," + 
			   		"	NoofDays int(20)," + 
			   		"	Workload int(20)" + 
			   		");";
			   statement.executeLargeUpdate(table3);
			   
			   String populateTable3 = "insert into clients values (0001, 'Client1', 'Tech Company', 'IT Worker', 5000, 4, 2);";
			   String populateTable3a = "insert into clients values (0002, 'Client2', 'Clothing Company', 'Machine Worker', 3000, 3, 1);";
			   String populateTable3b = "insert into clients values (0003, 'Client3', 'Food Comany', 'Chef', 2500, 1, 3);";
			   statement.executeLargeUpdate(populateTable3);
			   statement.executeLargeUpdate(populateTable3a);
			   statement.executeLargeUpdate(populateTable3b);

		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}		
}
