/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import static com.vaadin.event.LayoutEvents.LayoutClickListener;

/**
 * Created by arauzca on 24.12.16.
 */
public class CustomMenuItem extends HorizontalLayout {
    public CustomMenuItem(String caption, String icon) {
        this.setStyleName("menu-item");

        if(icon == null || icon.isEmpty()) {
            icon = "no-icon";
        }

        StringBuilder iconStyle = new StringBuilder("menu-item-icon").append("-").append(icon);
        Label imageIcon = new Label();
        imageIcon.setStyleName(iconStyle.toString());

        Label itemCaption = new Label(caption);
        itemCaption.setStyleName("menu-item-caption");
        itemCaption.setWidthUndefined();

        this.addComponents(imageIcon, itemCaption);
    }

    public void addClickListener(LayoutClickListener event) {
        this.addLayoutClickListener(event);
    }
}
