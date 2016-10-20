package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */

@SuppressWarnings("unused")
public class Building {

    private string name;
    private string address;

    public string getName() {
        return name;
    }

    public string getAddress() {
        return address;
    }

    public void setAddress(string address) {
        this.address = address;
    }

    public void setName(string name) {
        this.name = name;
    }
}
