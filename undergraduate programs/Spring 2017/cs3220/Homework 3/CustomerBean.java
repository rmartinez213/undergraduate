package Homework3;

public class CustomerBean {

	static int counter = 0;

	int id;
	String name;
	String description;

	CustomerBean(int id, String name, String description) {
		super();
		this.id = counter++;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
