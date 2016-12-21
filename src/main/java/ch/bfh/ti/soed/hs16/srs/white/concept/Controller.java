/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

/**
 * Created by arauzca on 09.12.16.
 */
public abstract class Controller {

    public abstract void init();

    public Controller() {
        init();
    }
}
