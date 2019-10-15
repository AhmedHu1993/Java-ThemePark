import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.visit(attraction);
        attraction.incrementVisitCount();
    }

    public HashMap allReviews(){
        HashMap<String, Integer> allReviews = new HashMap<>();

        for (Object place : getAllReviewed()){

            IReviewed site = (IReviewed)place;
            String name = site.getName();
            int rating = site.getRating();

            allReviews.put(name, rating);
        }
        return allReviews;
    }

    public ArrayList allAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allAllowed = new ArrayList<>();

        for (Object place : getAllReviewed()){
            ISecurity site = (ISecurity) place;
            if (site.isAllowedTo(visitor)) {
                allAllowed.add((IReviewed) place);
            }
        }
        return allAllowed;
    }
}
