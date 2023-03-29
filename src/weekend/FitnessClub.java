package weekend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitnessClub {

	Month[] months;
	List<Booking> bookings;
	List<Customer> customers;
	String[] month_names = { "March", "April" };

	public FitnessClub() {

		months = new Month[2];
		months[0] = new Month();
		months[1] = new Month();
		bookings = new ArrayList<>();

		customers = new ArrayList<>();
		customers.add(new Customer(0, "David", "0237-448575"));
		customers.add(new Customer(1, "Salman", "0224-438573"));
		customers.add(new Customer(2, "Alex", "0234-143577"));
		customers.add(new Customer(3, "Sarah", "0234-162578"));
		customers.add(new Customer(4, "Brad", "0234-428574"));
		customers.add(new Customer(5, "Alexa", "0234-343574"));
		customers.add(new Customer(6, "Cortana", "0232-248473"));
		customers.add(new Customer(7, "Adam", "0234-648473"));
		customers.add(new Customer(8, "Kabir", "0234-4246534"));

	}

	public static void main(String[] args) {
		FitnessClub club = new FitnessClub();
		club.run();
	}

	int selectCustomer(Scanner scanner) {
		int count = customers.size();
		while (true) {
			System.out.println("Please select your customer id!");
			for (Customer customer : customers) {
				System.out.println(customer.toString());
			}
			try {

				int choice = scanner.nextInt();
				scanner.nextLine();
				if (choice < count && choice >= 0)
					return choice;
				System.out.println("Invalid choice try again!");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Please Enter a number!");
			}
		}
	}

	public void run() {

		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println("Welcome to the Weekend Fitness Club!");
			String[] menu_options = { "Book a group fitness lesson", "Change/Cancel a booking", "Attend a lesson",
					"Monthly lesson report", "Monthly champion fitness type report", "Quit" };
			int choice = getOptionSelected(menu_options, scanner);

			switch (choice) {
			case 0:
				int c_id = selectCustomer(scanner);
				int m_id = getOptionSelected(month_names, scanner);
				bookLesson(scanner, c_id, m_id);

				break;
			case 1:
				// changeBooking(scanner);
				break;
			case 2:
				// attendLesson(scanner);
				break;
			case 3:
				// monthlyLessonReport();
				break;
			case 4:
				// monthlyChampionReport();
				break;
			case 5:
				quit = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}
		}
		System.out.println("Thank you for using the Weekend Fitness Club system!");
	}

	int getOptionSelected(String[] options, Scanner scanner) {
		int count = options.length;
		while (true) {
			System.out.println("Please select an option!");
			int i = 0;
			for (String str : options) {
				System.out.println(i++ + ". " + str);
			}
			try {

				int choice = scanner.nextInt();
				scanner.nextLine();
				if (choice < count && choice >= 0)
					return choice;
				System.out.println("Invalid choice try again!");
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Enter a Number!");

			}
		}
	}

	private void bookLesson(Scanner scanner, int c_id, int m_id) {
		System.out.println("Please select the way to check the timetable:");
		String[] timeTable_options = { "By specifying the day and shift.", "By specifying the fitness type." };
		int option = getOptionSelected(timeTable_options, scanner);

		if (option == 0) {
			String[] dayOptions = { "Saturday Morning", "Saturday Evening", "Sunday Morning", "Sunday Evening" };
			int shift = getOptionSelected(dayOptions, scanner);
			int selction = getOptionSelected(months[m_id].timeTableByshift(shift), scanner);
			int week = selction / 4;
			int type = selction % 4;
			if (!bookingExists(m_id, week, shift, type, c_id)) {
				if (months[m_id].isAvailabe(week, shift, type)) {
					months[m_id].book(week, shift, type);
					Booking b = new Booking(m_id, week, shift, type, c_id);
					bookings.add(b);
					System.out.println("Booking Successful, Your booking id is: " + b.id);
				} else {
					System.out.println("Sorry booking full. try a different time.");
				}
			} else {

				System.out.println("Sorry! You can not book this lesson again.");
			}
		} else if (option == 1) {

			String[] typeOptions = { "Spin", "Yoga", "Zumba", "Aquacise" };
			int type = getOptionSelected(typeOptions, scanner);
			int selction = getOptionSelected(months[m_id].timeTableByType(type), scanner);
			int week = selction / 4;
			int shift = selction % 4;
			if (!bookingExists(m_id, week, shift, type, c_id)) {
				if (months[m_id].isAvailabe(week, shift, type)) {
					months[m_id].book(week, shift, type);
					Booking b = new Booking(m_id, week, shift, type, c_id);
					bookings.add(b);
					System.out.println("Booking Successful, Your booking id is: " + b.id);
				} else {
					System.out.println("Sorry booking full. try a different time.");
				}
			} else {

				System.out.println("Sorry! You can not book this lesson again.");
			}
		}
	}

	boolean bookingExists(int month, int week, int shift, int type, int c_id) {
		for (Booking booking : bookings) {
			if (booking.c_id == c_id && booking.month == month && booking.weekend == week && booking.shift == shift
					&& booking.type == type && booking.status != 3)
				return true;
		}
		return false;
	}
}
