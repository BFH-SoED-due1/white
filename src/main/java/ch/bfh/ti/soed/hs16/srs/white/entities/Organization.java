/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import ch.bfh.ti.soed.hs16.srs.white.concept.Building;
import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by joni on 20.10.2016.
 */
public class Organization {
    private Set<EndUser> endUsers = new HashSet<>();
    private Set<Building> building = new HashSet<>();

    public Set<EndUser> getEndUsers() {
        Set<EndUser> readOnlyEndUsers = Collections.unmodifiableSet(this.endUsers);
        return readOnlyEndUsers;
    }

    public void removeEndUser(EndUser endUser){
        this.endUsers.remove(endUser);
        endUser.destroy(); //not sure
        //TODO remove all endUsers reservations
    }

    public void addEndUser(EndUser endUser) {
        this.endUsers.add(endUser);
    }

    public Set<Building> getBuildings() {
        Set<Building> readOnlyBuilding = Collections.unmodifiableSet(this.building);
        return readOnlyBuilding;
    }

    public void removeBuilding(Building building){
        this.building.remove(building);
        building.destroy();
    }

    public void addBuilding(Building building){
        this.building.add(building);
    }


}
