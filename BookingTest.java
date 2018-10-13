/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Ravi
 */
public class BookingTest {
    Guest guest;
    Room room;
    CreditCard creditcard;
    
    
    public BookingTest() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

       /**
     * Test of addServiceCharge method, of class Booking.
     */
    @Test
    public void testAddServiceCharge() {
        System.out.println("addServiceCharge");
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        double cost = 450.0;
        this.guest = new Guest("ravi", "aaa", 664646);
        this.room = new Room(101, RoomType.SINGLE);
        Date arrivalDate = new Date(2019, 02, 12);
        this.creditcard = new CreditCard(CreditCardType.VISA, 4, 445);
        Booking instance = new Booking(guest, room, arrivalDate, 5, 1, creditcard);
        instance.addServiceCharge(serviceType, cost);
        
    }
    
    /**
     * Test of getCharges method, of class Booking.
     */
    @Test
    public void testGetCharges() {
        System.out.println("getCharges");
        
        Double expResult = 450.0;
        
        ServiceType serviceType = ServiceType.BAR_FRIDGE;
        Double cost = 450.0;
                
        this.guest = new Guest("ravi", "aaa", 664646);
        this.room = new Room(101, RoomType.SINGLE);
        
        Date arrivalDate = new Date(2019, 02, 12);
        
        this.creditcard = new CreditCard(CreditCardType.VISA, 4, 445);
        Booking book = new Booking(guest, room, arrivalDate, 5, 1, creditcard);
        
        book.addServiceCharge(serviceType, cost);
        List<ServiceCharge> result = book.getCharges();
        ServiceCharge tot = result.get(0);
        Double t = tot.getCost();
        System.out.println(t);
        assertEquals(expResult, t);
        
    }

    



    
}
