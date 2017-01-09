/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Room;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by hyamsj on 20.10.2016.
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
    public void testRemoveOneRoomDoesntRemoveAnotherOne(){
        Organization org = new Organization();
        Room room1 = new RoomImpl(1,"", 0);
        ReservationImpl reservation1 = new ReservationImpl();
        org.addRoom(room1);
        room1.addReservation(reservation1);
        assertEquals(1, room1.getReservations().size());
        org.removeRoom(room1);
        assertEquals(0, room1.getReservations().size());

        Room room2 = new RoomImpl(1,"", 0);
        ReservationImpl reservation2 = new ReservationImpl();
        org.addRoom(room2);
        room1.addReservation(reservation2);
        assertEquals(1, room1.getReservations().size());
    }

    @Test
    public void testRemoveCertainReservations(){
        Organization org = new Organization();
        Room room1 = new RoomImpl(1,"", 0);
        Room room2 = new RoomImpl(1,"", 0);
        org.addRoom(room1);
        org.addRoom(room2);
        org.removeRoom(room2);
        assertTrue(!org.getRooms().contains(room2));
        assertTrue(org.getRooms().contains(room1));

    }

    @Test
    public void testDeletedRoom(){
        // TODO delete room, what happens to reservations in it?
        Reservation reservation = new ReservationImpl();
        Organization org = new Organization();
        Room room = new RoomImpl(1,"", 0);
        org.addRoom(room);
        reservation.setReservedRoom(room);
        org.removeRoom(room);
        assertEquals(0, room.getReservations().size());
        assertEquals(0, org.getRooms().size());

    }

    @Test
    public void testRemoveRoomRemovesReservations(){
        Organization org = new Organization();
        Room room = new RoomImpl(1,"123", 20);
        Reservation res = new ReservationImpl();

        org.addRoom(room);
        room.addReservation(res);
        assertEquals(1, room.getReservations().size());
        org.removeRoom(room);
        assertEquals(0, room.getReservations().size());


    }





}