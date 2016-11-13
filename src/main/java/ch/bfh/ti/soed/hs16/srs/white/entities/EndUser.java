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

public class EndUser {
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private Set<Reservation> reservations = new HashSet<>();
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public Set<Reservation> getReservations() {
        Set<Reservation> readOnlyReservations = Collections.unmodifiableSet(this.reservations);
        return readOnlyReservations;
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public void addReservations(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void destroy() {
        reservations.clear();

    }
}
