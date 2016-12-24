/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.Model;

import java.util.Collections;
import java.util.List;

/**
 * Created by arauzca on 24.12.16.
 */
public abstract class AbstractModel implements Model {
    // Class variables
    protected List data;

    // Abstract methods
    public abstract boolean loadModel();

    // Public methods
    @Override
    public List getData() {
        List unmodifiable = Collections.unmodifiableList(data);
        return unmodifiable;
    }

    @Override
    public void addData(Object o) {
        data.add(o);
    }
}
