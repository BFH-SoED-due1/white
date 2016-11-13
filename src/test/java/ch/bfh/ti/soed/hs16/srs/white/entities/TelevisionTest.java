package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by angelo on 11/13/16.
 */
public class TelevisionTest {

    @Test
    public void TestGettersAndSetters(){
        Equipment b = new Television("hallo", 111, 1, "1280x720",150);
        StringBuilder attr = new StringBuilder();
        attr.append("hallo");
        attr.append(111);
        attr.append(1);
        attr.append("1280x720");
        attr.append(150);


        assertEquals(attr.toString(), b.getAttributes());
    }
}
