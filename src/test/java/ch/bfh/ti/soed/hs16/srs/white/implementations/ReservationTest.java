/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hyamsj on 20.10.2016.
 */
public class ReservationTest {
    @Test
    public void testGettersAndSetters() {
        ReservationImpl reservation = new ReservationImpl();
        EndUserImpl user = new EndUserImpl();
        RoomImpl room = new RoomImpl(1,"", 0);

        reservation.setReservedRoom(room);
        assertEquals(room, reservation.getReservedRoom());

        reservation.setOwner(user);
        assertEquals(user, reservation.getOwner());

        // TODO test Time setTime and getTime with better Date Class


    }



}