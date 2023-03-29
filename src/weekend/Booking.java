package weekend;

public class Booking {
	int month;
	int weekend;
	int shift;
	int type;
	int id;
	int status;
	int rating;
	int c_id;
	String review;
	static int last_id = 0;
	public Booking(int month, int weekend, int shift, int type, int c_id) {
		super();
		this.month = month;
		this.weekend = weekend;
		this.shift = shift;
		this.type = type;
		this.status = 1;
		this.c_id = c_id;
		id = ++last_id;
		
	}
	
	

}
