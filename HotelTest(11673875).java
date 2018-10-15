/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceType;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ranith
 */
public class HotelTest {
    
    private Guest hotelGuest;
    private Room hotelRoom;
    private CreditCard creditCard;
    private Date arrivalDate;
    private Booking booking;
    
    public HotelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of checkout method, of class Hotel.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        this.hotelGuest = new Guest("Ranith", "Sri Lanka", 712452);
        this.hotelRoom = new Room(101, RoomType.SINGLE);
        this.arrivalDate = new Date(2018,11,22);
        this.creditCard = new CreditCard(CreditCardType.VISA, 4, 777);
        String expectedResult = null;
        
        Hotel hotel = new Hotel();
        long confirmation = hotel.book(hotelRoom, hotelGuest, arrivalDate, 8, 1, creditCard);
        hotel.checkin(confirmation);
        hotel.checkout(hotelRoom.getId());
        
        Booking booking = hotel.activeBookingsByRoomId.get(hotelRoom.getId());
        
        assertEquals( expectedResult, booking);
        System.out.println(booking);

    }
    
}