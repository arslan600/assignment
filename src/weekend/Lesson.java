package weekend;

public class Lesson {
	String day;
	String shift;
	String lesson_type;
	int available;
	
	public Lesson() {
		available = 5;
		
	}
	
	@Override
	public String toString() {
		return day+ " " + shift + " " + lesson_type + ", " + available + " bookings available.";
	}
}
