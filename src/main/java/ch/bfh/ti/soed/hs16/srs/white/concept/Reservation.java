package ch.bfh.ti.soed.hs16.srs.white.concept;

/**
 * Created by joni on 01/12/16.
 */
public interface Reservation {
    EndUser getOwner();
    Room getReservedRoom();
    void setReservedRoom(Room reservedRoom);
}
