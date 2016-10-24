package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */

@SuppressWarnings("unused")
public class Building {

    private String name;
    private String address;
    private Set<Room> rooms = new HashSet();

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        Set<Room> readOnlyRooms = Collections.unmodifiableSet(this.rooms);
        return readOnlyRooms;
    }

    public void removeRoom(Room room){
        rooms.remove(room);
//        room.removeAllReservations();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }


    public void destroy() {
        rooms.forEach((room)->room.removeAllReservations());
        rooms.clear();
    }
}
