/*
 * This program will test Hotel.java
 * 
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isurika
 */
public class TestHotel {

    Booking booking;
    Guest guest;
    Room room;
    CreditCard creditCard;
    Map<Integer, Booking> activeBookingsByRoomId;

    public TestHotel() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test checkout method.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        this.guest = new Guest("Isurika", "Dandenong", 0404234600);
        this.room = new Room(101, RoomType.SINGLE);
        Date arrivalDate = new Date(2019, 01, 25);
        this.creditCard = new CreditCard(CreditCardType.VISA, 4, 445);
        String expected_result = null;
        
        Hotel hotel = new Hotel();
        long confirmationNumber = hotel.book(room, guest, arrivalDate, 1, 1, creditCard);
        hotel.checkin(confirmationNumber);
        hotel.checkout(this.room.getId());

        Booking booking = hotel.activeBookingsByRoomId.get(this.room.getId());

        assertEquals( expected_result, booking.getRoomId());  
        System.out.println(booking.getRoomId());
 
    }
}