/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.Rights;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by joni on 20.10.2016.
 */
public class RightsTest {

    @Test
    public void userHasOneRight() {
        int id = 10;
        String firstName = "Max";
        String lastName = "Tester";
        String mail = "Rights@tester.com";
        EndUserImpl user = new EndUserImpl(id, firstName, lastName, mail);
        user.setRights(Rights.READ);

        Iterator i = user.getRights().iterator();

        assertEquals(i.next(), Rights.READ);

        assertEquals(Rights.valueOf("DELETE"), Rights.DELETE);
        Rights[] rightsArray = Rights.values();
        assertEquals(4, rightsArray.length);

    }

}