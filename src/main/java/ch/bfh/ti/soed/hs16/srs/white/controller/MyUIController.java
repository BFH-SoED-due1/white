/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import com.vaadin.ui.UI;

/**
 * Created by arauzca on 24.10.16.
 */
public class MyUIController implements Controller {
    private UI myUI;

    public MyUIController(UI myUI) {
        this.myUI       = myUI;
    }

    @Override
    public void init() {
        LogInController controller = new LogInController();
        LogInView firstView = new LogInView( controller );

        firstView.load(myUI);
    }
}
