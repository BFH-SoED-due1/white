package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class BuildingTest {

    @Test
    public void testGettersAndSetters(){
        Building rolex = new Building();
        rolex.setName("Rolex");
        assertEquals("Rolex", rolex.getName());

        rolex.setAddress("Quellgasse");
        assertEquals("Quellgasse",rolex.getAddress());

    }

    @Test
    public void testRemoveBuilding(){
        Building building = new Building();
        Room room = new Room();
        building.addRoom(room);
        building.removeRoom(room);
        assertTrue(building.getRooms().isEmpty());

    }

    @Test
    public void testRemoveCertainReservations(){
        Building building = new Building();
        Room room1 = new Room();
        Room room2 = new Room();
        building.addRoom(room1);
        building.addRoom(room2);
        building.removeRoom(room2);
        assertTrue(!building.getRooms().contains(room2));
        assertTrue(building.getRooms().contains(room1));


    }



    @Test
    public void testDeletedRoom(){
        // TODO delete room, what happens to reservations in it?
        Reservation reservation = new Reservation();
        Building building = new Building();
        Room room = new Room();
        building.addRoom(room);
        reservation.setReservedRoom(room);
        building.removeRoom(room);
        assertEquals(0, room.getReservations().size());
        assertEquals(0, building.getRooms().size());


    }

    @Test
    public void testRemoveBuildingRemovesReservations(){
        Building building = new Building();
        Room room = new Room();
        Reservation reservation = new Reservation();

        building.addRoom(room);
        room.addReservation(reservation);

        building.destroy();

        assertEquals(0, building.getRooms().size());
        assertEquals(0, room.getReservations().size());
    }



}