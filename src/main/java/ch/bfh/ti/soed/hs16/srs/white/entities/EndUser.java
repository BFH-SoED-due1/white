package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Set;

/**
 * Created by arauzca on 19.10.16.
 */

public class EndUser {
    private int id;
    private String mail;
    private String firstName;
    private String lastName;
    private Set<Reservation> reservations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }


}
