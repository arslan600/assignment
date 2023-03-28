package weekend;

public class Month {

	Weekend[] weekends;
	
	
	public Month() {
		weekends = new Weekend[4];
		for (int i = 0; i < weekends.length; i++) {
			weekends[i] = new Weekend();
		}
	}
	
	
}
