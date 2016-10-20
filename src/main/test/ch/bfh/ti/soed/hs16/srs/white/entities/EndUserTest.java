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
        user.setFirstName("FirstName");
        assertEquals("FirstName", user.getFirstName());

        user.setLastName("LastName");
        assertEquals("LastName", user.getLastName());

        user.setId(42);
        assertEquals(42, user.getId());

        user.setMail("white@mailinator.com");
        assertEquals("white@mailinator.com", user.getMail());

    }

    @Test
    public void testAddReservations(){
        EndUser user = new EndUser();
        Reservation res = new Reservation();
        user.addReservations(res);
        assertTrue(user.getReservations().contains(res));

    }

    @Test
    public void testRemoveReservations(){
        EndUser user = new EndUser();
        Reservation res = new Reservation();
        user.removeReservation(res);
        assertTrue(user.getReservations().isEmpty());

    }



}