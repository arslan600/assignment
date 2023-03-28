package weekend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessClub {

	Month[] months;
	List<Booking> booking;
	public FitnessClub() {
		months = new Month[2];
		booking = new ArrayList<>();
		
	}
	public static void main(String[] args) {
		FitnessClub club = new FitnessClub();
		club.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println("Welcome to the Weekend Fitness Club!");
			System.out.println("Please select an option:");
			System.out.println("1. Book a group fitness lesson");
			System.out.println("2. Change/Cancel a booking");
			System.out.println("3. Attend a lesson");
			System.out.println("4. Monthly lesson report");
			System.out.println("5. Monthly champion fitness type report");
			System.out.println("6. Quit");
			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
				bookLesson(scanner);
				break;
			case 2:
				// changeBooking(scanner);
				break;
			case 3:
				// attendLesson(scanner);
				break;
			case 4:
				// monthlyLessonReport();
				break;
			case 5:
				// monthlyChampionReport();
				break;
			case 6:
				quit = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}
		System.out.println("Thank you for using the Weekend Fitness Club system!");
	}

	private void bookLesson(Scanner scanner) {
		System.out.println("Please select the way to check the timetable:");
		System.out.println("1. By specifying the day (Saturday or Sunday)");
		System.out.println("2. By specifying the fitness type");
		int option = scanner.nextInt();
		scanner.nextLine(); // consume the newline character

		String day = "";
		String type = "";
		if (option == 1) {
			System.out.println("Please enter the day (Saturday or Sunday):");
			day = scanner.nextLine();
		} else if (option == 2) {
			System.out.println("Please enter the fitness type:");
			type = scanner.nextLine();
		} else {
			System.out.println("Invalid option. Please try again.");
			return;
		}

		// List<Lesson> lessons =
	}
}
