/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCreateMap;

import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Maps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author clement
 */
public class TestMapClement {
    Maps map;
    Plain plain1;
    Plain plain2;
    
    private Case[][] test;
    
    public TestMapClement(){
    }
    
    @Before
    public void Startup(){
        plain1 = new Plain();
        plain2 = new Plain();
        test = new Case[2][2];
    }
    
    @After
    public void TearDown(){
        plain1 = null;
        plain2 = null;
        map = null;
    }
    
    @Test
    public void Maps2X1TestPlain(){
        test[0][0] = plain1;
        test[0][1] = plain2;
        map = new Maps(1,2,test);
        System.out.println(map.getCase(0, 0));
        System.out.println(map.getCase(0, 1));
    }
}
