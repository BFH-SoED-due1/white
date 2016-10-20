package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class EndUserTest {
    @Test
    public void testGettersAndSetters(){
        EndUser user = new EndUser();
        user.setFirstName("UserName");
        assertEquals("UserName", user.getFirstName());

        user.setId(42);
        assertEquals(42, user.getId());

        user.setMail("xyz@bfh.ch");
        assertEquals("xyz@bfh.ch", user.getMail());


    }


}