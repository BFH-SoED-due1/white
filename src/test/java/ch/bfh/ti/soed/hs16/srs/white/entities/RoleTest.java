/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class RoleTest {

    @Test
    public void testGettersAndSetters(){
        Role role = new Role();
        role.setName("Admin");
        assertEquals("Admin", role.getName());

        //role.setRights(Rights.CREATE);
        //assertEquals(Rights.CREATE, role.getRole());
    }

}