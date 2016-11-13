/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Date;

/**
 * Created by arauzca on 19.10.16.
 */
@SuppressWarnings("unused")
public class Reservation {
    private EndUser owner;
    private Room reservedRoom;
    private Date time; //TODO find a better type for time so it can be established if a reservation overlaps another one.

    //TODO create constructor so Reservations always need a Time
    public Reservation() {
        this(null, null, null);
    }

    public Reservation(EndUser owner, Room room, Date time) {
        this.owner = owner;
        this.reservedRoom = room;
        this.time = time;
    }

    public EndUser getOwner() {
        return owner;
    }

    public void setOwner(EndUser owner) {
        this.owner = owner;
    }

    public Room getReservedRoom() {
        return reservedRoom;
    }

    public void setReservedRoom(Room reservedRoom) {
        this.reservedRoom = reservedRoom;
    }




}
