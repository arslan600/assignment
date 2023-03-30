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

	public Booking(String csv) {
		String[] data = csv.split(",");
		try {

			
			this.month = Integer.parseInt(data[0].strip());
			this.weekend = Integer.parseInt(data[1].strip());
			this.shift = Integer.parseInt(data[2].strip());
			this.type = Integer.parseInt(data[3].strip());
			this.id = Integer.parseInt(data[4].strip());
			this.status = Integer.parseInt(data[5].strip());
			this.rating = Integer.parseInt(data[6].strip());
			this.c_id = Integer.parseInt(data[7].strip());
			this.review = data[8].strip();
			last_id = id;
		} catch (Exception e) {
			System.out.println("Error loading the booking"+ e.toString());
		}
	}

	@Override
	public String toString() {
		return month + ", " + weekend + ", " + shift + ", " + type + ", " + id + ", " + status + ", " + rating + ", "
				+ c_id + ", " + review;
	}

}
