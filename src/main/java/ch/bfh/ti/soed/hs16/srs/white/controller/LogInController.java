/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController implements Controller {
    private EndUserModel endUserModel;

    // UI Components of the View
    public TextField       mailField;
    public PasswordField   passwordField;
    public Button          loginButton;
    public Button          registerButton;
    public Label           messageLabel;


    public LogInController() {
        this.endUserModel   = EndUserModel.getInstance();
    }

    @Override
    public void init() {

    }

    public void login() {
        String mail = mailField.getValue();
        String pw   = passwordField.getValue();

        if ( mail.isEmpty() && pw.isEmpty() ) {
            messageLabel.setValue("Please enter your e-mail address and your password to log in");
        } else if ( mail.isEmpty() ) {
            messageLabel.setValue("Please enter your e-mail address");
        } else if ( pw.isEmpty()) {
            messageLabel.setValue("Please enter your password");
        } else {
            if ( endUserModel.checkLogin(mail, pw) ) {
                messageLabel.setValue( "Login Successful" );
            } else {
                messageLabel.setValue( "Login Failed" );
            }
        }
    }




}
