/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;

/**
 * Created by arauzca on 21.12.16.
 */
public abstract class AbstractController implements Controller {
    public abstract void init();
    public AbstractController() {
        init();
    }
}
