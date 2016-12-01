/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.Building;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */

@SuppressWarnings("unused")
public class BuildingImpl implements ch.bfh.ti.soed.hs16.srs.white.concept.Building {

    private String name;
    private String address;
    private Set<Room> rooms = new HashSet();

    public BuildingImpl(){
        this(null, null);
    }

    public BuildingImpl(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Set<Room> getRooms() {
        Set<Room> readOnlyRooms = Collections.unmodifiableSet(this.rooms);
        return readOnlyRooms;
    }

    @Override
    public void removeRoom(Room room){
        room.removeAllReservations();
        rooms.remove(room);
    }

    @Override
    public void addRoom(Room room) {
        this.rooms.add(room);
    }


    @Override
    public void destroy() {
        rooms.forEach((room)->room.removeAllReservations());
        rooms.clear();
    }
}
