package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 7);
        visitor1 = new Visitor(17, 180, 60);
        visitor2 = new Visitor(20, 175, 45);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void testVisitorAllowedToTobaccoStall() {
        assertEquals(false, tobaccoStall.isAllowedTo(visitor1));
        assertEquals(true, tobaccoStall.isAllowedTo(visitor2));
    }

    @Test
    public void hasRating(){
        assertEquals(7, tobaccoStall.getRating());
    }
}
