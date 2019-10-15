import attractions.Attraction;
import behaviours.IReviewed;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(){
        attractions = new ArrayList<>();
        stalls = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void addStall(Stall stall){
        stalls.add(stall);
    }

    public ArrayList getAllReviewed(){
        ArrayList<IReviewed> reviewed = new ArrayList<>();

        for (Attraction attraction : attractions){
            if (attraction instanceof IReviewed){
                reviewed.add(attraction);
            }
        }

        for (Stall stall : stalls){
            if (stall instanceof IReviewed){
                reviewed.add(stall);
            }
        }
        return reviewed;
    }
}
