+/*
 * This program will test Booking.java 
 * 
 */
package hotel.entities;

import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isurika
 */
public class TestBooking {
    Guest guest;
    Room room;
    CreditCard creditcard;
    
    
    public TestBooking() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

     /**
     * Test addServiceCharge method.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        double cost = 500.0;
        this.guest = new Guest("Isurika", "Dandenong", 0404234600);
        this.room = new Room(101, RoomType.SINGLE);
        Date arrivalDate = new Date(2019, 01, 25);
        this.creditcard = new CreditCard(CreditCardType.VISA, 4, 445);
        Booking instance = new Booking(guest, room, arrivalDate, 1, 1, creditcard);
        instance.addServiceCharge(serviceType, cost);
        
    }
    
    /**
     * Test getCharges method.
     */
    @Test
    public void testGetCharges() {
        System.out.println("getCharges");
        
        Double expResult = 500.0;
        
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        Double cost = 500.0;
                
        this.guest = new Guest("Isurika", "Dandenong", 0404234600);
        this.room = new Room(101, RoomType.SINGLE);
        
        Date arrivalDate = new Date(2019, 01, 25);
        
        this.creditcard = new CreditCard(CreditCardType.VISA, 4, 445);
        Booking book = new Booking(guest, room, arrivalDate, 1, 1, creditcard);
        
        book.addServiceCharge(serviceType, cost);
        List<ServiceCharge> result = book.getCharges();
        ServiceCharge tot = result.get(0);
        Double t = tot.getCost();
        System.out.println(t);
        assertEquals(expResult, t);
        
    }    
}