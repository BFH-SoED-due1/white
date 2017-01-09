/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

import java.util.List;

/**
 * Created by arauzca on 26.12.16.
 */
public abstract class AbstractTableController extends AbstractController {
    // Abstact methods
    public abstract List getData();
    public abstract boolean deleteData(int ID);
}
