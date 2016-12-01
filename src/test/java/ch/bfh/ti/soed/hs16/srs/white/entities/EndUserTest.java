/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by joni on 20.10.2016.
 */
public class EndUserTest {
    @Test
    public void testGettersAndSetters(){
        int id = 42;
        String firstName = "FirstName";
        String lastName = "LastName";
        String mail = "white@mailinator.com";
        EndUserImpl user = new EndUserImpl(id, firstName, lastName, mail);

        assertEquals("FirstName", user.getFirstName());


        assertEquals("LastName", user.getLastName());


        assertEquals(42, user.getId());


        assertEquals("white@mailinator.com", user.getMail());

    }

    @Test
    public void testAddReservations(){
        EndUserImpl user = new EndUserImpl();
        ReservationImpl res = new ReservationImpl();
        user.addReservations(res);
        assertTrue(user.getReservations().contains(res));

    }

    @Test
    public void testRemoveReservations(){
        EndUserImpl user = new EndUserImpl();
        ReservationImpl res = new ReservationImpl();
        user.addReservations(res);
        user.removeReservation(res);
        assertTrue(user.getReservations().isEmpty());

    }

    @Test
    public void testRemoveCertainReservations(){
        EndUserImpl user = new EndUserImpl();
        ReservationImpl res1 = new ReservationImpl();
        ReservationImpl res2 = new ReservationImpl();
        user.addReservations(res1);
        user.addReservations(res2);
        user.removeReservation(res2);
        assertTrue(!user.getReservations().contains(res2));
        assertTrue(user.getReservations().contains(res1));
    }

    @Test
    public void testRemoveEndUserRemovesReservations(){
        Organization organization = new Organization();
        EndUserImpl user = new EndUserImpl();
        ReservationImpl res = new ReservationImpl();

        organization.removeEndUser(user);
        assertEquals(0, user.getReservations().size());
    }

}