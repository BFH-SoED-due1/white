/**
 * Copyright (c) 2017 Team White, Berner Fachhochschule, Switzerland.
 * Project smart Reservations System.
 * Distributable under GPL license. See terms of license at gnu.org
 */

package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController {
    private UI mainUI;
    private LogInView logInView;

    public LogInController(UI mainUI) {
        this.mainUI = mainUI;
        logInView = new LogInView(this);
    }

    public void loadView() {
        logInView.load(mainUI);
    }

    public void clickMe(AbstractLayout layout, TextField name) {
        layout.addComponent(new Label("Thanks " + name.getValue()
                + ", it works! "));
    }

    public void getLogin(TextField mail, PasswordField password){
        String n = mail.getValue();
        String p = password.getValue();
        System.out.println(n); //for testing purposes
        System.out.println(p); //for testing purposes

    }
}
