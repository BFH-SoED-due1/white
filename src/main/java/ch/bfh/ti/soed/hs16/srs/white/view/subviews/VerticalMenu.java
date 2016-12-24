/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by arauzca on 24.12.16.
 */
public class VerticalMenu extends VerticalLayout {
    public void addMenuItem(CustomMenuItem menuItem) {
        this.addComponent(menuItem);
    }
}
