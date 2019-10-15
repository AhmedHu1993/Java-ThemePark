package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(13, 140, 40);
        visitor2 = new Visitor(13, 205, 50);
        visitor3 = new Visitor(11, 150, 70);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void testRollerCoasterAllowedToVisitors(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
        assertEquals(true, rollerCoaster.isAllowedTo(visitor2));
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void testPriceForVisitors() {
        assertEquals(rollerCoaster.defaultPrice(), rollerCoaster.priceFor(visitor1), 0);
        assertEquals(8.4, rollerCoaster.priceFor(visitor1), 0);
        assertEquals(2 * rollerCoaster.defaultPrice(), rollerCoaster.priceFor(visitor2), 0);
        assertEquals(16.8, rollerCoaster.priceFor(visitor2), 0);
    }
}
