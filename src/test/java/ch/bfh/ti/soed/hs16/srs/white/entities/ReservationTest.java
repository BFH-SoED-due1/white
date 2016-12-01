/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class ReservationTest {
    @Test
    public void testGettersAndSetters() {
        ReservationImpl reservation = new ReservationImpl();
        EndUserImpl user = new EndUserImpl();
        RoomImpl room = new RoomImpl("", 0);

        reservation.setReservedRoom(room);
        assertEquals(room, reservation.getReservedRoom());

        reservation.setOwner(user);
        assertEquals(user, reservation.getOwner());

        // TODO test Time setTime and getTime with better Date Class


    }



}