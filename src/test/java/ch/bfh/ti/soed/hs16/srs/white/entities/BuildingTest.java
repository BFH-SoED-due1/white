package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.Building;
import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class BuildingTest {

    @Test
    public void testGettersAndSetters(){
        Building rolex = new BuildingImpl("Rolex", "Quellgasse");
        assertEquals("Rolex", rolex.getName());

        assertEquals("Quellgasse",rolex.getAddress());

    }

    @Test
    public void testRemoveBuilding(){
        Building building = new BuildingImpl();
        Room room = new RoomImpl("",0);
        building.addRoom(room);
        building.removeRoom(room);
        assertTrue(building.getRooms().isEmpty());

    }

    @Test
    public void testRemoveCertainReservations(){
        Building building = new BuildingImpl();
        Room room1 = new RoomImpl("", 0);
        Room room2 = new RoomImpl("", 0);
        building.addRoom(room1);
        building.addRoom(room2);
        building.removeRoom(room2);
        assertTrue(!building.getRooms().contains(room2));
        assertTrue(building.getRooms().contains(room1));


    }



    @Test
    public void testDeletedRoom(){
        // TODO delete room, what happens to reservations in it?
        Reservation reservation = new ReservationImpl();
        Building building = new BuildingImpl();
        Room room = new RoomImpl("", 0);
        building.addRoom(room);
        reservation.setReservedRoom(room);
        building.removeRoom(room);
        assertEquals(0, room.getReservations().size());
        assertEquals(0, building.getRooms().size());


    }

    @Test
    public void testRemoveBuildingRemovesReservations(){
        BuildingImpl buildingImpl = new BuildingImpl();
        RoomImpl room = new RoomImpl("", 0);
        ReservationImpl reservation = new ReservationImpl();

        buildingImpl.addRoom(room);
        room.addReservation(reservation);

        buildingImpl.destroy();

        assertEquals(0, buildingImpl.getRooms().size());
        assertEquals(0, room.getReservations().size());
    }



}