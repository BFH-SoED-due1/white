package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class BuildingTest {

    @Test
    public void testGettersAndSetters(){
        Building rolex = new Building();
        rolex.setName("Rolex");
        AssertEquals("Rolex", rolex.getName);

        rolex.setAddress("Quellgasse");
        AssertEquals("Quellgasse",rolex.getAddress);


    }

}