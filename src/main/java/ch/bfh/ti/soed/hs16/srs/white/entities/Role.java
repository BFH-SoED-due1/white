/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by angelo on 10/20/16.
 */
public class Role {

    private String name;
    private Set<Rights> rights = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Rights> getRights() {
        Set<Rights> readOnlyRights = Collections.unmodifiableSet(this.rights);
        return readOnlyRights;
    }

    public void removeRights(Rights rights){
        this.rights.remove(rights);
    }

    public void setRights(Rights rights) {
        this.rights.add(rights);
    }
}
