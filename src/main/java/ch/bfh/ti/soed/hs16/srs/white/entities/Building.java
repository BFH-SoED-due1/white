package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */

@SuppressWarnings("unused")
public class Building {

    private String name;
    private String address;

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
}
