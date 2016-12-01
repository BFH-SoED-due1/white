package ch.bfh.ti.soed.hs16.srs.white.concept;

import java.util.Set;

/**
 * Created by joni on 01/12/16.
 */
public interface EndUser {

    int getId();
    String getFirstName();
    String getLastName();
    String getMail();
    Set<Reservation> getReservations();
    void removeReservation(Reservation reservation);
    void addReservations(Reservation reservation);
    void destroy();
}
