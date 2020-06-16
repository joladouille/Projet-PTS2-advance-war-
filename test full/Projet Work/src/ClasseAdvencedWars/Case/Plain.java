package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import sample.BibliotequeImage;

import java.util.ArrayList;


/**
 * 
 */
public class Plain extends Case {
    /**
     * Default constructor
     */
    
    public Plain() {
        super(BibliotequeImage.plaine);
    }
    
    public Plain(Building building) {
        super(building, BibliotequeImage.plaine);
    }

    @Override
    public boolean getWalkable(Units unit) {
        boolean sortie = false;
        if(
        (unit instanceof Infantry) ||
        (unit instanceof Tank) ||
        (unit instanceof RocketLauncher)
        ){
            sortie = true;
        }
        return sortie;
    }
}