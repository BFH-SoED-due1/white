/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by hyamsj on 20.10.2016.
 */
public class EndUserTest {
    @Test
    public void testGettersAndSetters(){
        int id = 42;
        String firstName = "FirstName";
        String lastName = "LastName";
        String mail = "white@mailinator.com";
        EndUser user = new EndUserImpl(id, firstName, lastName, mail);

        assertEquals("FirstName", user.getFirstName());


        assertEquals("LastName", user.getLastName());


        assertEquals(42, user.getId());


        assertEquals("white@mailinator.com", user.getMail());

    }

    @Test
    public void testAddReservations(){
        EndUser user = new EndUserImpl();
        Reservation res = new ReservationImpl();
        user.addReservations(res);
        assertTrue(user.getReservations().contains(res));

    }

    @Test
    public void testRemoveReservations(){
        EndUser user = new EndUserImpl();
        ReservationImpl res = new ReservationImpl();
        user.addReservations(res);
        user.removeReservation(res);
        assertTrue(user.getReservations().isEmpty());

    }

    @Test
    public void testRemoveCertainReservations(){
        EndUser user = new EndUserImpl();
        Reservation res1 = new ReservationImpl();
        Reservation res2 = new ReservationImpl();
        user.addReservations(res1);
        user.addReservations(res2);
        user.removeReservation(res2);
        assertTrue(!user.getReservations().contains(res2));
        assertTrue(user.getReservations().contains(res1));
    }

    @Test
    public void testRemoveEndUserRemovesReservations(){
        Organization organization = new Organization();
        EndUser user = new EndUserImpl();
        Reservation res = new ReservationImpl();
        user.addReservations(res);

        organization.removeEndUser(user);
        assertEquals(0, user.getReservations().size());
    }

    @Test
    public void testEqualsMethod(){

        EndUser user1 = new EndUserImpl(0,"x", "y", "z");
        EndUser user2 = new EndUserImpl(0,"a", "b", "c");
        assertFalse(user1.equals(user2));

        user1 = new EndUserImpl(0,null, "y", "z");
        user2 = new EndUserImpl(0,"x", "y", "z");
        assertFalse(user1.equals(user2));

        user1 = new EndUserImpl(0,"x", null, "z");
        user2 = new EndUserImpl(0,"x", "y", "z");
        assertFalse(user1.equals(user2));

        user1 = new EndUserImpl(0,"x", "y", null);
        user2 = new EndUserImpl(0,"x", "y", "z");
        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));

        user1 = new EndUserImpl(0,null, "y", "z");
        user2 = new EndUserImpl(0,null, "b", "c");
        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));

        user1 = new EndUserImpl(0,"x", null, "z");
        user2 = new EndUserImpl(0,"a", null, "c");
        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));

        user1 = new EndUserImpl(0,"x", "y", null);
        user2 = new EndUserImpl(0,"a", "b", null);
        assertFalse(user1.equals(user2));

        int hash = 23671443;
        EndUser user3 = new EndUserImpl(0, null, null, null);
        assertEquals(hash, user3.hashCode());


        EndUser user4 = new EndUserImpl(0, null, null, "test");
        user4.hashCode();

        hash = 24014936;
        assertEquals(hash, user1.hashCode());
    }

}