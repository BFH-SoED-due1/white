package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class ReservationTest {
    @Test
    public void testGettersAndSetters() {
        Reservation reservation = new Reservation();
        EndUser user = new EndUser();
        Room room = new Room();

        reservation.setReservedRoom(room);
        assertEquals(room, reservation.getReservedRoom());

        reservation.setOwner(user);
        assertEquals(user, reservation.getOwner());

        // TODO test Time setTime and getTime with better Date Class


    }



}