package people;

import attractions.Park;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Park park;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        park = new Park("Botanic", 7);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }

    @Test
    public void hasVisitedPlaces(){
        assertEquals(0, visitor.getVisitedAttraction().size());
    }

    @Test
    public void visitAttractions(){
        visitor.visit(park);
        assertEquals(1, visitor.getVisitedAttraction().size());
    }
}
