/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by arauzca on 24.12.16.
 */
public class UsersView extends AbstractView {
    @Override
    public Component load() {
        VerticalLayout usersLayout = new VerticalLayout();
        return usersLayout;
    }

    @Override
    public Controller loadController() {
        return null;
    }

    @Override
    public void restart() {

    }
}
