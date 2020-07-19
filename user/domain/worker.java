package user.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class worker {
	/*
	 * Correspond to the user table
	 */
	
	private String WorkerID;
	private String Name; 
	private int Age;
	private String Email;
	private String WorkerType; 
	private String Skill;
	private String SalaryRange;
	private int reviews;
	
	public String getWorkerID() {
		return WorkerID;
	}
	public void setWorkerID(String workerID) {
		WorkerID = workerID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getWorkerType() {
		return WorkerType;
	}
	public void setWorkerType(String workerType) {
		WorkerType = workerType;
	}
	public String getSkill() {
		return Skill;
	}
	public void setSkill(String skill) {
		Skill = skill;
	}
	public String getSalaryRange() {
		return SalaryRange;
	}
	public void setSalaryRange(String salaryRange) {
		SalaryRange = salaryRange;
	}
	public int getReviews() {
		return reviews;
	}
	public void setReviews(int reviews) {
		this.reviews = reviews;
	}
	



}

	
	

	/*
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * 
	 * @Override public String toString() { return "User [ username=" + username +
	 * ", password=" + password + ", email=" + email +"]"; }
	 */

