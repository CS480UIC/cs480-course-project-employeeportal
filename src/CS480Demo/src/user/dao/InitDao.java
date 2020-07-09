package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import java.sql.Statement;

/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class InitDao {
	
	Statement statement = null;
	
	public void InitDatabase() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			Connection connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employeeportal?"
					+ "user=root&password=modi9akhil");
		   statement = connect.createStatement();
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
		   
		   
		 
		 
		    		
		
		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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
