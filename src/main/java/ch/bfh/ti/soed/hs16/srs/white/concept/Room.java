/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

import java.util.Set;

/**
 * Created by hyamsj on 01/12/16.
 */
public interface Room {
    int getId();

    String getName();
    int getQuantityOfSeats();
    Set<Reservation> getReservations();
    void removeReservation(Reservation reservation);
    void addReservation(Reservation reservation);
    void removeAllReservations();
}
