package ClasseAdvencedWars.Case.Building;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Units;
import Exception.FriendException;
import Exception.SpawnException;


/**
 * 
 */
public class Base extends Building {
    
    private final static int PAYOUT = 10;
    
    
    private final Team OWNER;
    
    private boolean onCapture=false;
    
    
    
    /**
     * Default constructor
     */
    public Base(Team owner) {
        super();
        this.OWNER = owner;
    }

    @Override
    public Team getOwner() {
        return this.OWNER;
    }

    @Override
    public int getPayout() {
        return this.PAYOUT;
    }
    
    public void spawn(Maps map, Units unit) throws FriendException, SpawnException{
        Case terrain = map.getCase(map.GetLocal(this).getX(), map.GetLocal(this).getY());
        if(terrain.getUnit() != null){
            throw new SpawnException("case occuped");
        }else if(this.OWNER.getMoney()< unit.getCost()){
            throw new SpawnException("units is too expencive");
        }else {
            this.OWNER.pay(unit.getCost());
            terrain.setUnit(unit);
        }
    }

    @Override
    public void onEndTurn() {
        if(!onCapture){
            onCapture = true;
            this.getOwner().ChangeIncome(this.PAYOUT);
        }
    }
    
}