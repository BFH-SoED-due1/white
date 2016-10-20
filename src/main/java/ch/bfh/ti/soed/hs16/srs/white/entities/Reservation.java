package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Date;

/**
 * Created by arauzca on 19.10.16.
 */
@SuppressWarnings("unused")
public class Reservation {
    private EndUser owner;
    private Date time; //TODO find a better type for time so it can be established if a reservation overlaps another one.
    private Room reservedRoom;
}
