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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arauzca on 19.10.16.
 */

public class EndUserImpl implements EndUser{
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private Set<Reservation> reservations = new HashSet<>();
    private Set<Rights> rights = new HashSet<>(); //TODO

    public EndUserImpl() {
        this((int)(Math.random() * 10000),null,null,null);
    }

    public EndUserImpl(int id, String firstName, String lastName, String mail) {
        this.id         = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.mail       = mail;
    }


    @Override
    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    @Override
    public String getFirstName() {
        return firstName;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    @Override
    public String getLastName() {
        return lastName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    @Override
    public String getMail() {
        return mail;
    }

//    public void setMail(String mail) {
//        this.mail = mail;
//    }


    @Override
    public Set<Reservation> getReservations() {
        Set<Reservation> readOnlyReservations = Collections.unmodifiableSet(this.reservations);
        return readOnlyReservations;
    }

    @Override
    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    @Override
    public void addReservations(Reservation reservation) {
        this.reservations.add(reservation);
    }

    @Override
    public void destroy() {
        reservations.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!EndUser.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final EndUser other = (EndUser) obj;

        if (this.id != other.getId()) {
            return false;
        }

        if ( this.firstName == null ? !(other.getFirstName() == null) : !this.firstName.equals(other.getFirstName()) ) {
            return false;
        }

        if ( this.lastName == null ? !(other.getLastName() == null) : !this.lastName.equals(other.getLastName()) ) {
            return false;
        }

        if ( this.mail == null ? !(other.getMail() == null) : !this.mail.equals(other.getMail()) ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 53 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 53 * hash + (this.mail != null ? this.mail.hashCode() : 0);
        return hash;
    }

    @Override
    public EndUserImpl clone() {
        EndUserImpl clonedEndUser = new EndUserImpl(this.id, this.firstName, this.lastName, this.mail);

        if ( this.reservations.size() > 0) {
            this.reservations.forEach(e -> {
                clonedEndUser.addReservations(e);
            });
        }

        return clonedEndUser;
    }
}
