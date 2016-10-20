package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class OrganizationTest {
    @Test
    public void testRemove(){

    }

    @Test
    public void deleteBuildingDeletesReservations(){
        //@Dubuis
        //Should this only be tested as a Room object that gets deleted and loses it's reservations
        //Is the chain of events unnecessary?
        Organization organization = new Organization();
        Building building = new Building();
        Room room = new Room();
        Reservation reservation = new Reservation();
        organization.addBuilding(building);
        building.addRoom(room);
        reservation.setReservedRoom(room);
        organization.removeBuilding(building);
        assertNull(reservation);

    }

    @Test
    public void testRemoveEndUserRemovesReservations(){
        Organization organization = new Organization();
        EndUser user = new EndUser();
        Reservation res = new Reservation();

        organization.removeEndUser(user);
        assertNull(res);
    }

}