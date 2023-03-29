package weekend;

public class Customer {
	int id;
	String name;
	String phone;
	
	@Override
	public String toString() {
		return id + ", " + name ;
	}

	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

}
