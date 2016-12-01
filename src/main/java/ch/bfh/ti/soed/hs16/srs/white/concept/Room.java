package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.entities.ReservationImpl;

import java.util.Set;

/**
 * Created by joni on 01/12/16.
 */
public interface Room {
    String getName();

    int getQuantityOfSeats();

    Set<Reservation> getReservations();

    void removeReservation(Reservation reservation);

    void addReservation(Reservation reservation);

    void removeAllReservations();
}
