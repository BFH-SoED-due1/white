/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;

/**
 * Created by arauzca on 21.12.16.
 */
public abstract class AbstractController implements Controller {
    // Class variables
    // Constructors
    public AbstractController() {
        init();
    }

    // Abstract methods
    public abstract void init();

    // Public methods
    public void goBack(AbstractView lastView) {
        ApplicationController applicationController = ApplicationController.getInstance();
        applicationController.loadView( lastView );
    }
}
