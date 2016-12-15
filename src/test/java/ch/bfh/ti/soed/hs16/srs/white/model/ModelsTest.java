/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.Model;
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by arauzca on 13.11.16.
 */
public class ModelsTest {

    /*@Test
    public void testReservation() {
        assertTrue(EndUserModel.testConnection());
        ReservationModel rm = new ReservationModel();                               // Initializing ReservationModel
        Model um = new EndUserModel();                                       // Initializing EndUserModel

        EndUser e1 = new EndUserImpl(0, "Carlos", "Arauz", "carlos.arauz@bfh.ch");
        EndUser e2 = new EndUserImpl(1, "Pablo", "Donan", "pablo.donan@bfh.ch");
        EndUser e3 = new EndUserImpl(3, "Carlos", "Arauz", "carlos.arauz@bfh.ch");

        System.out.println(e1.toString());

        um.createEndUser(e1);
        um.createEndUser(e2);
        um.saveUsers();
        um.loadEndUsers("users.xml");
        um.loadEndUsers("nofile.xml");



        List<EndUser> endUserList = um.getEndUsers();

        assertFalse(e1.equals(null));
        assertFalse(e1.equals(new String("test")));
        assertFalse(e1.equals(e3));

        Room r1 = new RoomImpl("",0);                                                       // Creating a room, later will be loaded with model


        Date d1 = new Date();
        Date d2 = new Date();

        rm.makeReservation(e1, r1, d1);                                             // User e1 make some reservations
        rm.makeReservation(e1, r1, d2);

        assertEquals(r1.getReservations().size(), e1.getReservations().size());     // checks if the room and the user has the same amount of reservations
        assertTrue(e1.getReservations().containsAll(r1.getReservations()));         // checks if the user and the room has the same reservations, that is because the user has reserved 2 times the same room

        Set<Reservation> reservationsFromUser = ReservationModel.getReservationsFromUser(e1);   // get all reservations made from user e1


        assertEquals(2, reservationsFromUser.size());                                       // test if the user has made 2 reservations

        Cancel all reservations
        Set<Reservation> reservationsFromRoom = ReservationModel.getReservationsFromRoom(r1);
        assertEquals(2, reservationsFromRoom.size());

        Object[] ro = reservationsFromUser.toArray();


        EndUser endUser             = new EndUserImpl(1, "Carlos", "Arauz", "abc@xyz.com"); // from now on these are method tests to: clone, hash and equals for most of their branches
        //EndUser clonedEndUser       = e1.clone();

        for (int i = 0; i < ro.length; i++) {
            Reservation res = (ReservationImpl) ro[i];
            rm.cancelReservation(res);
        }

        assertEquals(0, e1.getReservations().size());                               // check if the 2 reservations were deleted from both the user and the room
        assertEquals(0, r1.getReservations().size());

        //assertTrue( endUser.equals(e1) );
        //assertTrue( endUser.equals(clonedEndUser) );
        //assertEquals(endUser.hashCode(), clonedEndUser.hashCode());

        EndUser e2 = new EndUserImpl(2, null, null, null);
        EndUser cloneE2 = e2.clone();

        um.createEndUser(e2);
        assertTrue( e2.equals(um.getEndUserById(2)) );

        um.deleteEndUserById(1);
        assertNull( um.getEndUserById(1) );

        assertFalse(endUser.equals(null));
        assertFalse(endUser.equals(um));
        assertFalse(endUser.equals(e2));

        assertTrue(e2.equals(cloneE2));

        //e2.setFirstName("Jan");

        //e2.setFirstName(null);
        //e2.setLastName("Mustername");

        //e2.setLastName(null);
        //e2.setMail("cde@xyz.com");

        assertFalse(cloneE2.equals(e2));

    }*/

    @Test
    public void testEndUserModel() {
        Model userModel;

        try {
            Connection dbConnection = DbConnection.getInstance();
            assertNotNull(dbConnection);

            PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM enduser");
            assertTrue(ps.execute());

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}