/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.io.File;

/**
 * Created by arauzca on 20.12.16.
 */
public class TemplateLayout extends AbstractView {
    private UI applicationUI;
    private VerticalLayout body = new VerticalLayout();

    public TemplateLayout(UI applicationUI) {
        this.applicationUI = applicationUI;
    }

    @Override
    public Component load() {
        VerticalLayout layout   = new VerticalLayout();
        String basePath         = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource resource   = new FileResource(new File(basePath + "/images/uite_logo.png"));

        Image imageLogo = new Image("", resource);
        imageLogo.setStyleName("logo-corner-300");

        LogInView logInView             = new LogInView();
        body.addComponent( logInView.load() );

        Label footer = FooterView.getInstance();

        layout.addComponents(imageLogo, body, footer);
        applicationUI.setContent(layout);

        return layout;
    }

    @Override
    public Controller loadController() {
        return null;
    }

    public void updateBody(Component newBody) {
        this.body.removeAllComponents();
        this.body.addComponent( newBody );
    }

}
