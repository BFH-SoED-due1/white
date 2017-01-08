/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import ch.bfh.ti.soed.hs16.srs.white.helpers.ResourcesHelper;
import com.vaadin.server.FileResource;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by arauzca on 20.12.16.
 */
public class TemplateLayout extends AbstractView {
    private ApplicationController applicationController;
    private VerticalLayout body = new VerticalLayout();

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
        this.applicationController = ApplicationController.getInstance();
        this.applicationController.setTemplateLayout(this);
        return applicationController;
    }

    @Override
    public void restart() {

    }

    @Override
    public void changeContent(View newContent) {

    }

    public void updateBody(Component newBody) {
        this.body.removeAllComponents();
        this.body.addComponent(newBody);
    }

}
