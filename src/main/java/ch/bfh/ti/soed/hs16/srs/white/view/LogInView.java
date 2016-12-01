/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView {
    private LogInController controller;

    public LogInView(LogInController controller) {
        this.controller = controller;
    }

    public void load(UI myUI) {
        final VerticalLayout layout = new VerticalLayout();

        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        final TextField mail = new TextField();
        mail.setCaption("Type your mail here:");

        final PasswordField password = new PasswordField();
        password.setCaption("Type your password here:");

        Button button1 = new Button("Click Me");
        button1.addClickListener( e -> {
            controller.clickMe(layout, name);
            controller.getLogin(mail, password);
            myUI.setContent(new TableView().createTable());
        });


        layout.addComponents(name, mail, password, button1);
        layout.setMargin(true);
        layout.setSpacing(true);

        myUI.setContent(layout);
    }
}
