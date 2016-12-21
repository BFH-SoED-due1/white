/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.server.Responsive;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView extends View {
    // Controller of this View
    private LogInController logInController;

    // UI Components
    private TextField       mailField           = new TextField();
    private PasswordField   passwordField       = new PasswordField();
    private Button          loginButton         = new Button("Log in");
    private Button          registerButton      = new Button("Register");
    private Label           messageLabel        = new Label("");

    public LogInView(){
        loadController();
    }

    @Override
    public Controller loadController() {
        logInController = new LogInController();

        logInController.setMailField(mailField);
        logInController.setPasswordField(passwordField);
        logInController.setMessageLabel(messageLabel);

        return logInController;
    }

    @Override
    public Component load() {
        final VerticalLayout formContainer = new VerticalLayout();
        formContainer.setStyleName("absolute-center");

        mailField.setCaption("Type your mail here:");
        mailField.setStyleName("textfield-form");

        passwordField.setCaption("Type your password here:");
        passwordField.setStyleName("textfield-form");

        loginButton.addClickListener(e -> {
            logInController.login();
        });

        loginButton.setStyleName("button-center");
        loginButton.setWidth("91px");

        registerButton.addClickListener(e -> {
            ApplicationController applicationController = ApplicationController.getInstance();
            applicationController.loadView( new RegistrationView() );
        });
        registerButton.setStyleName("button-center");
        registerButton.setWidth("91px");

        messageLabel.setStyleName("horizontal-center");
        messageLabel.setSizeUndefined();


        final HorizontalLayout buttonLayout = new HorizontalLayout();

        buttonLayout.addComponents(loginButton, registerButton);
        buttonLayout.setStyleName("horizontal-center");
        buttonLayout.setMargin(true);
        buttonLayout.setSpacing(true);

        formContainer.addComponents(mailField, passwordField, buttonLayout, messageLabel);
        formContainer.setMargin(true);
        formContainer.setSpacing(true);

        Responsive.makeResponsive(formContainer);

        return formContainer;

    }
}
