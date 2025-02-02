package ClasseAdvencedWars.units;

import ClasseAdvencedWars.Team;



/**
 * 
 */
public class Infantry extends Units {
        /**
     * 
     */
    private static final int VISION = 0;

    /**
     * 
     */
    private static final int MAXTRAVEL = 4;
    
    /**
     * 
     */
    private static final int COST = 5;
    
    public Infantry(Team owner) {
        super(owner);
        super.movePoint = Infantry.MAXTRAVEL;
    }


    public int getCost() {
        return COST;
    }
    @Override
    public void onEndTurn(){
        super.movePoint = Infantry.MAXTRAVEL;
    }
}