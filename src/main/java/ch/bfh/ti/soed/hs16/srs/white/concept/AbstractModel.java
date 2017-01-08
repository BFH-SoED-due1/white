/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Model;

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
        return Collections.unmodifiableList(data);
    }

    @Override
    public void addData(Object o) {
        data.add(o);
    }
}
