/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.model.AbstractModel;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;

import java.util.List;

/**
 * Created by arauzca on 26.12.16.
 */
public abstract class AbstractTableController extends AbstractController {
    // Model
    AbstractModel abstractModel;

    // Abstact methods
    public abstract List getData();
    public abstract boolean deleteData(int ID);
}
