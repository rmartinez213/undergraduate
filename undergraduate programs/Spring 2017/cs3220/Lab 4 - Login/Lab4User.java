package Lab4;


public class Lab4User {

	static int counter = 0;
	
	int id;
	String name;	
	String username;
	String password;
	
	
	public Lab4User(String name, String username, String password) {
		super();
		this.id = counter++;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
