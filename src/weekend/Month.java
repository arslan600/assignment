package weekend;

public class Month {

	Weekend[] weekends;
	
	
	public Month() {
		weekends = new Weekend[4];
		for (int i = 0; i < weekends.length; i++) {
			weekends[i] = new Weekend();
		}
	}
	
	String[] timeTableByType(int type) {
		String[] res = new String[16];
		for (int i = 0; i < weekends.length; i++) {
			for(int j=0; j< 4; j++) {
				res[i*4 + j] = "\tWeek"+ (i+1) +" "+weekends[i].lessons[j][type].toString();
			}
		}
		return res;
	}	
	String[] timeTableByshift(int shift) {
		String[] res = new String[16];
		for (int i = 0; i < weekends.length; i++) {
			for(int j=0; j< 4; j++) {
				res[i*4 + j] = "\tWeek"+ (i+1) +" "+weekends[i].lessons[shift][j].toString();
			}
		}
		return res;
	}

	boolean isAvailabe(int week, int shift, int type) {
		return weekends[week].lessons[shift][type].available > 0;
	}
	
	void book(int week, int shift, int type) {
		weekends[week].lessons[shift][type].available--;
	}
	
	void cancel(int week, int shift, int type) {
		weekends[week].lessons[shift][type].available++;
	}
	
}
