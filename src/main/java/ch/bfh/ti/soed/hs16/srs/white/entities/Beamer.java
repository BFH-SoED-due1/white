/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.HashMap;

/**
 * Created by joni on 12.11.2016.
 */
public class Beamer implements Equipment {
    private String name;
    private int quantity;
    private int id;

    // TODO print if for example VGA = true
    private HashMap<String, Boolean> ports = new HashMap<>();

    public Beamer(String n, int q, int id, HashMap<String, Boolean> p){
        this.name = n;
        this.quantity = q;
        this.id = id;
        this.ports = p;
    }

    @Override
    public String getAttributes() {
        StringBuilder attr = new StringBuilder();
        attr.append(this.name);
        attr.append(this.quantity);
        attr.append(this.id);
        return attr.toString();
    }


}
