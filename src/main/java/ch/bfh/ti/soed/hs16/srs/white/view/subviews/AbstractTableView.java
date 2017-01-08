/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by arauzca on 26.12.16.
 */
public abstract class AbstractTableView extends AbstractView {
    protected AbstractTableController abstractTableController;

    @Override
    public Component load() {
        VerticalLayout usersLayout = new VerticalLayout();
        List data = abstractTableController.getData();

        usersLayout.addComponent(createHeader());

        for (Object e : data) {
            Component itemView = createItemView(e);
            usersLayout.addComponent(itemView);
        }

        usersLayout.setMargin(true);
        usersLayout.setSpacing(true);

        return usersLayout;
    }

    @Override
    public void restart() {
        throw new UnsupportedOperationException();
    }

    // New abstract methods
    public abstract Component createItemView(Object o);
    public abstract Component createHeader();
}
