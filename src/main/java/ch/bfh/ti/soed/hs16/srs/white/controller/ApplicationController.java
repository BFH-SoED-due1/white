/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.view.TemplateLayout;
import com.vaadin.ui.UI;

/**
 * Created by arauzca on 20.12.16.
 */
public class ApplicationController implements Controller {
    private static ApplicationController uniqueApplicationController = new ApplicationController();
    private TemplateLayout templateLayout;

    private ApplicationController() {
    }

    @Override
    public void init() {
    }

    public void loadView(View v) {
        uniqueApplicationController.getTemplateLayout().updateBody(v.load());
    }

    public static ApplicationController getInstance() {
        return uniqueApplicationController;
    }

    public void setTemplateLayout(TemplateLayout templateLayout) {
        this.templateLayout = templateLayout;
    }

    protected TemplateLayout getTemplateLayout() {
        return templateLayout;
    }
}
