/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import ch.bfh.ti.soed.hs16.srs.white.controller.RegistrationController;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView {
    private LogInController loginController;
    private TextField nameField = new TextField();
    private TextField mailField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button("Click Me");
    private Button registerButton = new Button("Register");
    private Label messageLabel = new Label("");

    public LogInView(LogInController logInController){
        this.loginController = logInController;
    }



    public void load(UI myUI) {

        final VerticalLayout layout = new VerticalLayout();
        nameField.setCaption("Type your name here:");
        mailField.setCaption("Type your mail here:");
        passwordField.setCaption("Type your password here:");


        loginButton.addClickListener(e -> {
            loginController.login();

        });

        registerButton.addClickListener(e -> {

        });


        layout.addComponents(nameField, mailField, passwordField, loginButton, registerButton, messageLabel);
        layout.setMargin(true);
        layout.setSpacing(true);

        myUI.setContent(layout);
    }

    public TextField getNameField() {
        return nameField;
    }



    public TextField getMailField() {
        return mailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }
}
