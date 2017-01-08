/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.EndUser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by arauzca on 13.11.16.
 */
public class ModelsTest {

    @Test
    public void testEndUserModel() {
        EndUserModel endUserModel = EndUserModel.getInstance();
        endUserModel.loadModel();
        List<EndUser> endUsers = endUserModel.getData();
        EndUser jarjarBinks = null;
        String jarjarEmail = "jarjar.binks@death.star"; //

        assertTrue(endUserModel.saveUser("JarJar", "Binks", jarjarEmail, "1234567890"));  // Test: create user to the database and add it to the model

        for (EndUser e : endUsers) {
            String email = e.getMail();
            if (email.equals(jarjarEmail)) jarjarBinks = e;
        }

        if (jarjarBinks != null)
            assertTrue(endUserModel.deleteUser(jarjarBinks));

        EndUser adminModel = null;
        EndUser admin = endUserModel.getEndUserById(0);

        for (EndUser e : endUsers) {
            if (e.getMail().equals("admin")) {
                adminModel = e;
                break;
            }
        }

        assertEquals(adminModel, admin);
    }

    @Test
    public void testRoomModel(){
        /*RoomModel roomModel = RoomModel.getInstance();
        roomModel.loadModel();
        List<Room> rooms = roomModel.getData();
        Room room1 = null;
        roomModel.addData(room1);
        assertTrue(rooms.contains(room1));*/

    }


}