/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import com.vaadin.ui.Label;

/**
 * Created by arauzca on 18.12.16.
 */
public class FooterView extends Label {
    private static FooterView uniqueFooter;

    private FooterView() {
        super("© 2016 Berner Fachhochschule - SRS @ white team");
        this.setStyleName("footer");
    }

    public static FooterView getInstance() {
        if (uniqueFooter == null) {
            uniqueFooter = new FooterView();
        }

        return uniqueFooter;
    }
}
