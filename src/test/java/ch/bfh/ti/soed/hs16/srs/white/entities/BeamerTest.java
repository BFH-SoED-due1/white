package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by joni on 12.11.2016.
 */
public class BeamerTest {

    @Test
    public void TestGettersAndSetters(){
        HashMap<String, Boolean> equipment = new HashMap<>();
        Equipment b = new Beamer("abc", 123, 1, equipment);
        StringBuilder attr = new StringBuilder();
        attr.append("abc");
        attr.append(123);
        attr.append(1);

        assertEquals(attr.toString(), b.getAttributes());
    }

}