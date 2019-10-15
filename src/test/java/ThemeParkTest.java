import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;

    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;

    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;

    Visitor visitor1;

    @Before
    public void before(){
        themePark = new ThemePark();

        dodgems = new Dodgems("Bumber Cars", 7);
        park = new Park("Kinder Garden", 8);
        playground = new Playground("Fun Mania", 9);
        rollerCoaster = new RollerCoaster("Dark Coaster", 6);

        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);

        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 8);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 7);

        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);

        visitor1 = new Visitor(18, 190, 75);
    }

    @Test
    public void hasAttraction(){
        assertEquals(4, themePark.getAttractions().size());
    }

    @Test
    public void hasStalls(){
        assertEquals(3, themePark.getStalls().size());
    }

    @Test
    public void getReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void checkVisitingForVisitorAndAttraction(){
        themePark.visit(visitor1, rollerCoaster);
        assertEquals(rollerCoaster, visitor1.getVisitedAttraction().get(0));
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void checkHashMapOfReviews(){
        assertEquals(7, themePark.allReviews().size());
    }
}
