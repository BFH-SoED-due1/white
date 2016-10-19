package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Set;

/**
 * Created by arauzca on 19.10.16.
 */
@SuppressWarnings("unused")
public class Room {
    private String name;
    private int quantityOfSeats;
    private Set<Reservation> reservations;
}
