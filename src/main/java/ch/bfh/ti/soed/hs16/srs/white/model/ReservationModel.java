/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import ch.bfh.ti.soed.hs16.srs.white.implementations.ReservationImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arauzca on 13.11.16.
 */
public class ReservationModel {
    private Set<Reservation> reservations = new HashSet<>();

    public void makeReservation(EndUser user, Room room, Date date) {
        Reservation reservation = new ReservationImpl(user, room, date);

        reservations.add(reservation);
        user.addReservations(reservation);
        room.addReservation(reservation);
    }

    public void cancelReservation(Reservation reservation) {
        Room room = reservation.getReservedRoom();
        EndUser user = reservation.getOwner();

        room.removeReservation(reservation);
        user.removeReservation(reservation);
        this.reservations.remove(reservation);
    }

    public static Set<Reservation> getReservationsFromUser(EndUser user) {
        return user.getReservations();
    }

    public static Set<Reservation> getReservationsFromRoom(Room room) {
        return room.getReservations();
    }


}
