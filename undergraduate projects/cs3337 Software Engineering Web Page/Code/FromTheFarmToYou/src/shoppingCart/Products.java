package shoppingCart;

public class Products {

	int id;
	int farm_num;
	String name;
	String description;
	double price;
	int quantity;
	double totalPrice;
	
	public Products(){
		this.id = id;
		this.farm_num = farm_num;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFarm_num() {
		return farm_num;
	}

	public void setFarm_num(int farm_num) {
		this.farm_num = farm_num;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
	
	
	
}
