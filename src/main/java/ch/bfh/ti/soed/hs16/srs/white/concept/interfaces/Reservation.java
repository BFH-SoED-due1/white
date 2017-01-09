/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept.interfaces;

/**
 * Created by hyamsj on 01/12/16.
 */
public interface Reservation {
    EndUser getOwner();
    Room getReservedRoom();

    void setReservedRoom(Room reservedRoom);
}
