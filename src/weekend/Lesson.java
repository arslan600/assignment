package weekend;

public class Lesson {
	String day;
	String shift;
	String lesson_type;
	int total_rating;
	int total_attended;
	int available;
	float avg_rating;
	
	public Lesson() {
		total_attended = 0;
		total_rating = 0;
		available = 5;
		
	}
	
	@Override
	public String toString() {
		return day+ " " + shift + " " + lesson_type + ", " + available + " bookings available.";
	}
}
