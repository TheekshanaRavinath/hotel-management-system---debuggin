/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Ravi
 */
public class HotelTest {

    Booking booking;
    Guest guest;
    Room room;
    CreditCard creditCard;
    Map<Integer, Booking> activeBookingsByRoomId;

    public HotelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of checkout method, of class Hotel.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        this.guest = new Guest("Ravi", "VIC", 424554879);
        this.room = new Room(101, RoomType.SINGLE);
        Date arrivalDate = new Date(2019, 02, 25);
        this.creditCard = new CreditCard(CreditCardType.VISA, 4, 445);
        String expected_result = null;
        //Exception e = NullPointerException();
        
        Hotel hotel = new Hotel();
        long confirmationNumber = hotel.book(room, guest, arrivalDate, 5, 1, creditCard);
        hotel.checkin(confirmationNumber);
        hotel.checkout(this.room.getId());

        Booking booking = hotel.activeBookingsByRoomId.get(this.room.getId());

        assertEquals( expected_result, booking.getRoomId()); //check the room is still available in the map  
        System.out.println(booking.getRoomId());
 
    }

    

}
