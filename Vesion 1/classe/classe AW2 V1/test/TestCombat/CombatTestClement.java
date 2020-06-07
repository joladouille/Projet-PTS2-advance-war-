/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCombat;

import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Team;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import Exception.FriendException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class CombatTestClement {
    private Tank tank1;
    private Tank tank2;
   
    private RocketLauncher rLauncher1;
    private RocketLauncher rLauncher2;
    
    private Infantry infantry1;
    private Infantry infantry2;
    
    
    private Plain battleField;
    
    private Team teamB;
    private Team teamR;
    
    public CombatTestClement() {
    }
    
    @Before
    public void setup(){
        teamB = new Team("patrick");
        teamR = new Team("michel");
        
        tank1 = new Tank(teamB);
        tank2 = new Tank(teamR);

        rLauncher1 = new RocketLauncher(teamB);
        rLauncher2 = new RocketLauncher(teamR);
        
        infantry1 = new Infantry(teamB);
        infantry2 = new Infantry(teamR);

        battleField = new Plain();
        


    }
    
    @After
    public void TearDown(){
        teamB = null;
        teamR = null;
        
        tank1 = null;
        tank2 = null;
        
        battleField = null;
    }
    @Test
    public void setUnitTestTank() throws FriendException{
        battleField.setUnit(tank1);
        assert(battleField.getUnit().equals(tank1));
    }
    @Test
    public void setUnitTestRL() throws FriendException{
        battleField.setUnit(rLauncher1);
        assert(battleField.getUnit().equals(rLauncher1));
    }
    @Test
    public void setUnitTestInf() throws FriendException{
        battleField.setUnit(infantry1);
        assert(battleField.getUnit().equals(infantry1));
    }
    
    
    @Test
    public void AttackEgaliterTestTank() throws FriendException{
        battleField.setUnit(tank1);
        battleField.setUnit(tank2);
        assert(battleField.getUnit() == null);
    }
    @Test
    public void AttackEgaliterTestRL() throws FriendException{
        battleField.setUnit(rLauncher1);
        battleField.setUnit(rLauncher2);
        assert(battleField.getUnit() == null);
    }
    @Test
    public void AttackEgaliterTestInf() throws FriendException{
        battleField.setUnit(infantry1);
        battleField.setUnit(infantry2);
        assert(battleField.getUnit() == null);
    } 
    
    @Test
    public void AttackTestTankVSrLauncher() throws FriendException{
        battleField.setUnit(tank1);
        battleField.setUnit(rLauncher2);
        assert(battleField.getUnit() == rLauncher2);
    }
    @Test
    public void AttackTestrLauncherVSinf() throws FriendException{
        battleField.setUnit(rLauncher1);
        battleField.setUnit(infantry2);
        assert(battleField.getUnit() == infantry2);
    }
    @Test
    public void AttackTestInfVSTank() throws FriendException{
        battleField.setUnit(infantry1);
        battleField.setUnit(tank2);
        assert(battleField.getUnit() == tank2);
    }
    
    @Test
    public void AttackTestrLauncherVStank() throws FriendException{
        battleField.setUnit(rLauncher1);
        battleField.setUnit(tank2);
        assert(battleField.getUnit() == rLauncher1);
    }
    @Test
    public void AttackTestInfVSrLauncher() throws FriendException{
        battleField.setUnit(infantry1);
        battleField.setUnit(rLauncher2);
        assert(battleField.getUnit() == infantry1);
    }
    @Test
    public void AttackTestTankVSInf() throws FriendException{
        battleField.setUnit(tank1);
        battleField.setUnit(infantry2);
        assert(battleField.getUnit() == tank1);
    }
    
    @Test (expected=FriendException.class)
    public void FriendExceptionTest() throws FriendException{
        battleField.setUnit(tank1);
        battleField.setUnit(rLauncher1);
    }
}