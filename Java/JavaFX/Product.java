

public class Product{

	private String name;
	private double price;
	private int quantity;

	public Product(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(){
		this.name = "";
		this.price = 0.0;
		this.quantity = 0;
	}

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public int getQuantity(){
		return quantity;
	}
	public void setName(String name){
		this.name = name;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
}