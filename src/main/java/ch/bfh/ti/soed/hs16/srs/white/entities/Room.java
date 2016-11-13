/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arauzca on 19.10.16.
 */
@SuppressWarnings("unused")
public class Room {
    private String name;
    private int quantityOfSeats;
    private Set<Reservation> reservations = new HashSet<>();
    private Set<Equipment> equipments = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityOfSeats() {
        return quantityOfSeats;
    }

    public void setQuantityOfSeats(int quantityOfSeats) {
        this.quantityOfSeats = quantityOfSeats;
    }

    public Set<Reservation> getReservations() {
        Set<Reservation> readOnlyReservations = Collections.unmodifiableSet(this.reservations);
        return readOnlyReservations;
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }


    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void removeAllReservations(){
        reservations.clear();
    }

    public void addEquipments(Equipment c){
        this.equipments.add(c);
    }

    public Set<Equipment> getEquipments(){
        Set<Equipment> readOnlyEquipment = Collections.unmodifiableSet(this.equipments);
        return readOnlyEquipment;
    }
}
