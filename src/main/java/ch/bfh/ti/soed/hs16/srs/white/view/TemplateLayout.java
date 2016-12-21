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
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by arauzca on 20.12.16.
 */
public class TemplateLayout extends View {
    private Component body;

    public TemplateLayout(UI applicationUI) {
        super(applicationUI);
    }

    @Override
    public Component load() {
        VerticalLayout layout   = new VerticalLayout();
        String basePath         = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource resource   = new FileResource(new File(basePath + "/images/uite_logo.png"));

        Image imageLogo = new Image("", resource);
        imageLogo.setStyleName("logo-corner-300");

        LogInView logInView             = new LogInView( applicationUI );
        body = logInView.load();

        Label footer = FooterView.getInstance();

        layout.addComponents(imageLogo, body, footer);
        applicationUI.setContent(layout);

        return layout;
    }

    @Override
    public Controller loadController() {
        return null;
    }

    public void setBody(Component body) {
        this.body = body;
    }

}
