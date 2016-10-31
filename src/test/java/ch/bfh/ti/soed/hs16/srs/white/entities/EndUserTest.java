/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
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
        user.addReservations(res);
        user.removeReservation(res);
        assertTrue(user.getReservations().isEmpty());

    }

    @Test
    public void testRemoveCertainReservations(){
        EndUser user = new EndUser();
        Reservation res1 = new Reservation();
        Reservation res2 = new Reservation();
        user.addReservations(res1);
        user.addReservations(res2);
        user.removeReservation(res2);
        assertTrue(!user.getReservations().contains(res2));
        assertTrue(user.getReservations().contains(res1));
    }

    @Test
    public void testRemoveEndUserRemovesReservations(){
        Organization organization = new Organization();
        EndUser user = new EndUser();
        Reservation res = new Reservation();

        organization.removeEndUser(user);
        assertEquals(0, user.getReservations().size());
    }



    @Test
    public void testEndUserModel() {
        EndUserModel endUserModel = new EndUserModel();

        EndUser e = endUserModel.getEndUserById(1);
        assertEquals(e.getFirstName(), "Carlos");
        assertEquals(e.getLastName(), "Arauz");
        assertEquals(e.getMail(), "abc@xyz.com");

        EndUser e2 = new EndUser();
        e2.setId(2);

        endUserModel.createEndUser(e2);
        assertEquals(e2, endUserModel.getEndUserById(2));

        endUserModel.deleteEndUserById(1);
        assertNull(endUserModel.getEndUserById(1));

    }


}