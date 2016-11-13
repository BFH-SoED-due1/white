package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.entities.*;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by arauzca on 13.11.16.
 */
public class ModelsTest {

    @Test
    public void testReservation() {
        ReservationModel rm = new ReservationModel();                               // Initializing ReservationModel
        EndUserModel um = new EndUserModel();                                       // Initializing EndUserModel

        EndUser e1 = um.getEndUserById(1);                                          // get the User loaded with the Model

        Equipment t1 = new Television("tele1",1000,1000,"2500x1500",60);            // creating some Equipment
        Equipment c1 = new Computer("compi1",1,1,"1280x1080","macOS");

        Room r1 = new Room();                                                       // Creating a room, later will be loaded with model

        r1.addEquipments(t1);
        r1.addEquipments(c1);

        Date d1 = new Date();
        Date d2 = new Date();

        rm.makeReservation(e1, r1, d1);                                             // User e1 make some reservations
        rm.makeReservation(e1, r1, d2);

        assertEquals(r1.getReservations().size(), e1.getReservations().size());     // checks if the room and the user has the same amount of reservations
        assertTrue(e1.getReservations().containsAll(r1.getReservations()));         // checks if the user and the room has the same reservations, that is because the user has reserved 2 times the same room

        Set<Reservation> reservationsFromUser = ReservationModel.getReservationsFromUser(e1);   // get all reservations made from user e1

        Set<Equipment> equipmentSet = new HashSet<>();                              // Set of equipments for test
        equipmentSet.add(t1);
        equipmentSet.add(c1);

        assertTrue(r1.getEquipments().containsAll(equipmentSet));                   // testig if the room has the added equipment

        assertEquals(2, reservationsFromUser.size());                                       // test if the user has made 2 reservations

        /* Cancel all reservations */
        Set<Reservation> reservationsFromRoom = ReservationModel.getReservationsFromRoom(r1);
        assertEquals(2, reservationsFromRoom.size());

        Object[] ro = reservationsFromUser.toArray();


        EndUser endUser             = new EndUser(1, "Carlos", "Arauz", "abc@xyz.com"); // from now on these are method tests to: clone, hash and equals for most of their branches
        EndUser clonedEndUser       = e1.clone();

        for (int i = 0; i < ro.length; i++) {
            Reservation res = (Reservation) ro[i];
            rm.cancelReservation(res);
        }

        assertEquals(0, e1.getReservations().size());                               // check if the 2 reservations were deleted from both the user and the room
        assertEquals(0, r1.getReservations().size());

        assertTrue( endUser.equals(e1) );
        assertTrue( endUser.equals(clonedEndUser) );
        assertEquals(endUser.hashCode(), clonedEndUser.hashCode());

        EndUser e2 = new EndUser(2, null, null, null);
        EndUser cloneE2 = e2.clone();

        um.createEndUser(e2);
        assertTrue( e2.equals(um.getEndUserById(2)) );

        um.deleteEndUserById(1);
        assertNull( um.getEndUserById(1) );

        assertFalse(endUser.equals(null));
        assertFalse(endUser.equals(um));
        assertFalse(endUser.equals(e2));

        assertTrue(e2.equals(cloneE2));

        e2.setFirstName("Jan");

        assertFalse(cloneE2.equals(e2));

        e2.setFirstName(null);
        e2.setLastName("Mustername");

        assertFalse(cloneE2.equals(e2));

        e2.setLastName(null);
        e2.setMail("cde@xyz.com");

        assertFalse(cloneE2.equals(e2));

    }

}