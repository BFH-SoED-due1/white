/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractView;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by arauzca on 20.12.16.
 */
public class TemplateLayout extends AbstractView {
    private VerticalLayout body;

    @Override
    public Component load() {
        CustomLayout customLayout = new CustomLayout("template");

        LogInView logInView = new LogInView();
        body.addComponent(logInView.load());

        customLayout.addComponent(body, "body");
        return customLayout;
    }

    @Override
    public Controller loadController() {
        ApplicationController applicationController = ApplicationController.getInstance();
        this.body = new VerticalLayout();

        applicationController.setBody(this.body);

        return applicationController;
    }

    @Override
    public void restart() {

    }

    @Override
    public void changeContent(View newContent) {

    }



}
