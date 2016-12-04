/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Created by joni on 20.10.2016.
 */
public class OrganizationTest {
    @Test
    public void testAddAndRemoveEndUser(){
        Organization organization = new Organization();
        EndUser userRemain = new EndUserImpl();
        EndUser userRemove = new EndUserImpl();
        organization.addEndUser(userRemain);
        organization.addEndUser(userRemove);
        organization.removeEndUser(userRemove);

        assertEquals(1, organization.getEndUsers().size());
        assertFalse(organization.getEndUsers().contains(userRemove));
    }



    @Test
    public void removeEndUserDeletesReservations(){
        Organization organization = new Organization();
        EndUserImpl endUser = new EndUserImpl();
        ReservationImpl reservation = new ReservationImpl();
        organization.addEndUser(endUser);
        endUser.addReservations(reservation);
        organization.removeEndUser(endUser);
        assertEquals(0, endUser.getReservations().size());
        assertFalse(endUser.getReservations().contains(reservation));
    }

    @Test
    public void testRemoveOneRoomDoesntRemoveAnotherOne(){
        Organization org = new Organization();
        Room room1 = new RoomImpl("", 0);
        ReservationImpl reservation1 = new ReservationImpl();
        org.addRoom(room1);
        room1.addReservation(reservation1);
        assertEquals(1, room1.getReservations().size());
        org.removeRoom(room1);
        assertEquals(0, room1.getReservations().size());

        Room room2 = new RoomImpl("", 0);
        ReservationImpl reservation2 = new ReservationImpl();
        org.addRoom(room2);
        room1.addReservation(reservation2);
        assertEquals(1, room1.getReservations().size());
    }

}