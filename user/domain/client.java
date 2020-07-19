package user.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class client {
	/*
	 * Correspond to the user table
	 */
	
	private String email;
	private String company; 
	private String background;
	private String RequiredWorkertype;
	private String salaryafforded; 
	private String noofdays;
	private String workload;

	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getRequiredWorkertype() {
		return RequiredWorkertype;
	}
	public void setRequiredWorkertype(String requiredWorkertype) {
		RequiredWorkertype = requiredWorkertype;
	}
	public String getSalaryafforded() {
		return salaryafforded;
	}
	public void setSalaryafforded(String salaryafforded) {
		this.salaryafforded = salaryafforded;
	}
	public String getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(String noofdays) {
		this.noofdays = noofdays;
	}
	public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
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
}
