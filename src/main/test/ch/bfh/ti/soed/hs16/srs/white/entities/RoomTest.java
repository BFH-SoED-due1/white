package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class RoomTest {

    @Test
    public void testGettersAndSetters(){
        Room room = new Room();



    }

    @Test
    public void testDeletedRoom(){
        //TODO delete room, what happens to reservations in it?
        Reservation reservation = new Reservation();
        Building building = new Building();
        Room room = new Room();
        building.addRoom(room);
        reservation.setReservedRoom(room);
        building.removeRoom(room);
        assertNull(reservation);


    }



}