/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import com.vaadin.ui.UI;

/**
 * Created by arauzca on 24.10.16.
 */
public class MyUIController {
    private UI myUI;
    private LogInController logInController;

    public MyUIController(UI myUI) {
        this.myUI = myUI;
        logInController = new LogInController(this.myUI);
        initSystem();

    }

    public void initSystem() {
        logInController.loadView();
    }


}
