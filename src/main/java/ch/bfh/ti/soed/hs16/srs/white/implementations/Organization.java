/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by joni on 20.10.2016.
 */
public class Organization {
    private Set<EndUser> endUsers = new HashSet<>();
    private Set<Room> rooms = new HashSet();

    public Set<EndUser> getEndUsers() {
        Set<EndUser> readOnlyEndUsers = Collections.unmodifiableSet(this.endUsers);
        return readOnlyEndUsers;
    }

    public void removeEndUser(EndUser endUser){
        this.endUsers.remove(endUser);
        endUser.destroy();
        //TODO remove all endUsers reservations
    }

    public void addEndUser(EndUser endUser) {
        this.endUsers.add(endUser);
    }


    public Set<Room> getRooms() {
        Set<Room> readOnlyRooms = Collections.unmodifiableSet(this.rooms);
        return readOnlyRooms;
    }

    public void removeRoom(Room room){
        room.removeAllReservations();
        rooms.remove(room);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }


//    public void destroy() {
//        rooms.forEach((room)->room.removeAllReservations());
//        rooms.clear();
//    }


}
