/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by arauzca on 20.12.16.
 */
public class ApplicationController implements Controller {
    private static ApplicationController uniqueApplicationController = new ApplicationController();
    private VerticalLayout body; // Body from the TemplateLayout

    // Constructors
    private ApplicationController() {
    }

    @Override
    public void init() {}

    // Public class methods
    public void loadView(View v) {
        uniqueApplicationController.updateBody(v.load());
    }

    public static ApplicationController getInstance() {
        return uniqueApplicationController;
    }


    public void setBody(VerticalLayout body) {
        this.body = body;
    }

    // Private class methods
    private void updateBody(Component newBody) {
        VerticalLayout body = uniqueApplicationController.getBody();

        body.removeAllComponents();
        body.addComponent(newBody);
    }

    private VerticalLayout getBody() {
        return this.body;
    }
}
