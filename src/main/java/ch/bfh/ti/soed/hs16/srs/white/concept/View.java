/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

import com.vaadin.ui.Component;

/**
 * Created by arauzca on 09.12.16.
 */
public interface View {
    Component load();
    Controller loadController();
}
