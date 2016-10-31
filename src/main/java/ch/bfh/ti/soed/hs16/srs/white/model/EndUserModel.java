/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.entities.EndUser;

import java.util.HashMap;

/**
 * Created by arauzca on 21.10.16.
 */
public class EndUserModel {
    private HashMap<Integer, EndUser> endUsers;
    //private Hash<EndUser> endUsers;

    public EndUserModel() {
        this.endUsers = new HashMap<>();
        loadEndUsers();
    }

    /**
     * This function loads the users from the Database
     */
    private void loadEndUsers() {
        EndUser e = new EndUser();
        e.setId(1);
        e.setFirstName("Carlos");
        e.setLastName("Arauz");
        e.setMail("abc@xyz.com");

        endUsers.put(new Integer(e.getId()), e);
    }

    // TODO this needs more specifications
    public void createEndUser(EndUser e) {
        endUsers.put(e.getId(), e);
    }

    public void deleteEndUserById(Integer id) {
        endUsers.remove(id);
    }

    public EndUser getEndUserById(Integer id) {
        EndUser e = endUsers.getOrDefault(id, null);
        return e;
    }
}
