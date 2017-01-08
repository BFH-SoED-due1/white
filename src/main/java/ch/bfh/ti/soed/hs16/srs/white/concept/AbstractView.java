/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept;

import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import com.vaadin.ui.Component;

import javax.naming.OperationNotSupportedException;

/**
 * Created by arauzca on 21.12.16.
 */
public abstract class AbstractView implements View {
    // Class variables
    private AbstractView lastView;

    // Constructors
    public AbstractView() {
        loadController();
    }

    public AbstractView(AbstractView lastView) {
        this();
        this.lastView = lastView;
    }

    // Abstract methods
    public abstract Component load();

    public abstract Controller loadController();

    public abstract void restart() throws OperationNotSupportedException;

    public abstract void changeContent(View newContent);

    // Protected methods
    public AbstractView getLastView() {
        return lastView;
    }
}
