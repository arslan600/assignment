package weekend;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClubTest {

	// a sample booking string for testing
	String bookingStr = "1, 2, 2, 1, 3, 2, 5, 2, good and very nice lesson. should be taken every week.";
	
	@Test
	public void checkBookingConversion() {
		// Check if string to object and then back to string is consistent 
		Booking b = new Booking(bookingStr);
		assertEquals(bookingStr, b.toString());
	}
	
	@Test
	public void checkBookingCapacityConstraint() {
		Month m = new Month();
		// Make five bookings successfully  
		assertTrue(m.book(0, 0, 0));
		assertTrue(m.book(0, 0, 0));
		assertTrue(m.book(0, 0, 0));
		assertTrue(m.book(0, 0, 0));
		assertTrue(m.book(0, 0, 0));
		
		// sixth booking should fail
		assertFalse(m.book(0, 0, 0)); 
		
		//cancel a booking 
		assertTrue(m.cancel(0, 0, 0));
		
		//one more booking should be possible
		assertTrue(m.book(0, 0, 0));
		assertFalse(m.book(0, 0, 0)); 
	}
	

	@Test
	public void checkAttendFunctionality() {
		// if attend function puts values properly
		Booking b = new Booking(bookingStr);
		Month m = new Month();
		
		m.attend(b);
		//Check if rating added correctly
		assertEquals(m.weekends[b.weekend].lessons[b.shift][b.type].total_rating, b.rating);

	}
	
	@Test
	public void checkCancelFunctionality() {
		//  function cancel booking only if booked first
		Month m = new Month();
		
		//should not be able to cancel
		assertFalse(m.cancel(0, 0, 0));
		
		// add a booking
		assertTrue(m.book(0, 0, 0));
		
		// should be able to cancel now
		assertTrue(m.cancel(0, 0, 0));

	}
	
	@Test
	public void checkReports(){
		Month m = new Month();
		
		//check if generating report for all the lesson
		assertEquals(m.getReport().length, 64);
	}

}
