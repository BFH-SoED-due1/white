/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.Right;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Room;
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by arauzca on 13.11.16.
 */
public class ModelsTest {

    @Test
    public void testEndUserModel() throws SQLException {
        EndUserModel endUserModel = EndUserModel.getInstance();
        endUserModel.loadModel();
        List<EndUser> endUsers = endUserModel.getData();
        EndUser jarjarBinks = null;
        String jarjarEmail = "jarjar.binks@death.star";
        String jarjarPassword = "1234567890";
        Connection myconn = null;

        try {
            myconn = DbConnection.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(endUserModel.saveUser("JarJar", "Binks", jarjarEmail, jarjarPassword));  // Test: create user to the database and add it to the model
        assertFalse(endUserModel.saveUser("JarJar", "Binks", jarjarEmail, jarjarPassword)); // Should be false cause the user already exists

        assertTrue(endUserModel.checkLogin(jarjarEmail, jarjarPassword)); // checking if the new registered user can log in

        for (EndUser e : endUsers) {
            String email = e.getMail();
            if (email.equals(jarjarEmail)) jarjarBinks = e;
        }

        if (jarjarBinks != null) {
            assertTrue(endUserModel.deleteUser(jarjarBinks)); // succeeds, cause the user was already created
            assertFalse(endUserModel.deleteUser(jarjarBinks)); // it's false because the user was just deleted
        }

        EndUser adminModel = null;
        EndUser admin = endUserModel.getEndUserById(0);

        for (EndUser e : endUsers) {
            if (e.getMail().equals("admin")) {
                adminModel = e;
                break;
            }
        }

        assertEquals(adminModel, admin);
        assertNull(endUserModel.getEndUserById(-1));
        assertTrue(endUserModel.getNotUsedID(myconn, 1) != 1);
        assertTrue(endUserModel.getNotUsedID(myconn, 0) != 0);

    }

    @Test
    public void testCheckLoginFunction() throws SQLException {
        EndUserModel  endUserModel = EndUserModel.getInstance();

        // Testing with false log in data
        assertFalse(endUserModel.checkLogin("admin", "admin"));
        assertFalse(endUserModel.checkLogin("", "1234567890"));
        assertFalse(endUserModel.checkLogin("admin", ""));
        assertFalse(endUserModel.checkLogin("no_user", "no_password"));
        assertFalse(endUserModel.checkLogin("'admin'; DELETE FROM ENDUSER WHERE ID=1", "no_password")); // Trying to inject SQL
    }

    @Test
    public void testRoomModel() throws SQLException {
        RoomModel roomModel = RoomModel.getInstance();
        roomModel.loadModel();
        List<Room> rooms = roomModel.getData();
        Room room1 = null;
        roomModel.addData(room1);
        assertTrue(rooms.contains(room1));

        assertNotNull(RoomModel.getInstance());

        DbConnection connection = null;

        try {
            connection = DbConnection.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNotNull(connection.getConnection());
    }

    @Test
    public void testRight() {
        Right[] rights = Right.values();
        assertEquals(Right.ADMIN, Right.valueOf("ADMIN"));
        

    }
}