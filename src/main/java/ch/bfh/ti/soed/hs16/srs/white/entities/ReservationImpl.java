/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by arauzca on 19.10.16.
 */

@XmlRootElement(namespace ="http://ch.fbi.xml.beispielEins")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReservationImpl implements Reservation{
    private EndUser owner;
    private Room reservedRoom;
    private Date time; //TODO find a better type for time so it can be established if a reservation overlaps another one.

    //TODO create constructor so Reservations always need a Time
    public ReservationImpl() {
        this(null, null, null);
    }

    public ReservationImpl(EndUser owner, Room room, Date time) {
        this.owner = owner;
        this.reservedRoom = room;
        this.time = time;
    }

    @Override
    public EndUser getOwner() {
        return owner;
    }

    public void setOwner(EndUser owner) {
        this.owner = owner;
    }

    @Override
    public Room getReservedRoom() {
        return reservedRoom;
    }

    @Override
    public void setReservedRoom(Room reservedRoom) {
        this.reservedRoom = reservedRoom;
    }




}
