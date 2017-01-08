/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Room;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arauzca on 19.10.16.
 */

public class RoomImpl implements Room {
    private String name;
    private int id;
    private int quantityOfSeats;
    private Set<Reservation> reservations = new HashSet<>();

    public RoomImpl(int id, String name, int quantityOfSeats) {
        this.id = id;
        this.name = name;
        this.quantityOfSeats = quantityOfSeats;
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantityOfSeats() {
        return quantityOfSeats;
    }

    @Override
    public Set<Reservation> getReservations() {
        return Collections.unmodifiableSet(this.reservations);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }


    @Override
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public void removeAllReservations() {
        reservations.clear();
    }


}
