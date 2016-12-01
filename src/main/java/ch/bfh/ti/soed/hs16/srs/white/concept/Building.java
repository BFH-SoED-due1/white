package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.entities.RoomImpl;

import java.util.Set;

/**
 * Created by joni on 30/11/16.
 */
public interface Building {
    String getName();
    String getAddress();
    void removeRoom(Room room);
    void addRoom(Room room);
    void destroy();


    Set<Room> getRooms();
}
