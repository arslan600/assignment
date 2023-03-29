package weekend;

public class Weekend {
	Lesson[][] lessons;
	
	public Weekend() {
		lessons = new Lesson[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				lessons[i][j] = new Lesson();
			}
		}
		for (int i = 0; i < 4; i++) {
			lessons[i][0].lesson_type = "Spin";
			lessons[i][1].lesson_type = "Yoga";
			lessons[i][2].lesson_type = "Zumba";
			lessons[i][3].lesson_type = "Aquacise";
		}
		
		for (int i = 0; i < 4; i++) {
			lessons[0][i].shift = "Morning";
			lessons[1][i].shift = "Evening";
			lessons[2][i].shift = "Morning";
			lessons[3][i].shift = "Evening";
			lessons[0][i].day = "Saturday";
			lessons[1][i].day = "Saturday";
			lessons[2][i].day = "Sunday";
			lessons[3][i].day = "Sunday";
			
		}
	}
}
