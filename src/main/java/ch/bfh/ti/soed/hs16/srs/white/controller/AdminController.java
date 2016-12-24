/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import com.vaadin.ui.Component;

/**
 * Created by arauzca on 24.12.16.
 */
public class AdminController extends AbstractController {
    // View components
    private Component updatebleComponent;

    @Override
    public void init() {

    }

    public void setUpdatebleComponent(Component updatebleComponent) {
        this.updatebleComponent = updatebleComponent;
    }
}
