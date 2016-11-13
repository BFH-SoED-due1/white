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

    public EndUser() {
        this((int)(Math.random() * 10000),null,null,null);
    }

    public EndUser(int id, String firstName, String lastName, String mail) {
        this.id         = id;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.mail       = mail;
    }

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
    public EndUser clone() {
        EndUser clonedEndUser = new EndUser(this.id, this.firstName, this.lastName, this.mail);
        clonedEndUser.setRole( this.getRole() );

        if ( this.reservations.size() > 0) {
            this.reservations.forEach(e -> {
                clonedEndUser.addReservations(e);
            });
        }

        return clonedEndUser;
    }
}
