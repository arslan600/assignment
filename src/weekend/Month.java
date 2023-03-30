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
			for (int j = 0; j < 4; j++) {
				res[i * 4 + j] = "\tWeek" + (i + 1) + " " + weekends[i].lessons[j][type].toString();
			}
		}
		return res;
	}

	String[] timeTableByshift(int shift) {
		String[] res = new String[16];
		for (int i = 0; i < weekends.length; i++) {
			for (int j = 0; j < 4; j++) {
				res[i * 4 + j] = "\tWeek" + (i + 1) + " " + weekends[i].lessons[shift][j].toString();
			}
		}
		return res;
	}

	String[] getReport() {
		String[] res = new String[64];
		for (int i = 0; i < weekends.length; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					res[i * 16 + j * 4 + k] = "\tWeek" + (i + 1) + " " + weekends[i].lessons[j][k].reportString();
				}
			}
		}
		return res;
	}

	String[] getChampReport(int[] prices, String[] types) {
		String[] res = new String[5];
		int[] attend = { 0, 0, 0, 0 };
		int[] profits = new int[4];
		for (int i = 0; i < weekends.length; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					attend[k] += weekends[i].lessons[j][k].total_attended;
				}
			}
		}
		int highest = -1, highest_index = -1;
		for (int i = 0; i < 4; i++) {
			profits[i] = attend[i] * prices[i];
			if (profits[i] > highest) {
				highest = profits[i];
				highest_index = i;
			}
		}

		for (int i = 0; i < profits.length; i++) {
			res[i + 1] = types[i] + " earned $" + profits[i] + " in this month.";
		}
		res[0] = types[highest_index] + " earned highest $" + profits[highest_index] + " profit.";
		return res;
	}

	void attend(Booking booking) {
		weekends[booking.weekend].lessons[booking.shift][booking.type].total_rating += booking.rating;
		weekends[booking.weekend].lessons[booking.shift][booking.type].total_attended++;

		weekends[booking.weekend].lessons[booking.shift][booking.type].avg_rating = weekends[booking.weekend].lessons[booking.shift][booking.type].total_rating
				/ weekends[booking.weekend].lessons[booking.shift][booking.type].total_attended;
	}

	boolean isAvailabe(int week, int shift, int type) {
		return weekends[week].lessons[shift][type].available > 0;
	}

	boolean book(int week, int shift, int type) {
		if (isAvailabe(week, shift, type)) {
			weekends[week].lessons[shift][type].available--;
			return true;

		}
		return false;
	}

	boolean cancel(int week, int shift, int type) {
		if(weekends[week].lessons[shift][type].available < 5) {
			weekends[week].lessons[shift][type].available++;
			return true;
		}
		return false;
	}

}
