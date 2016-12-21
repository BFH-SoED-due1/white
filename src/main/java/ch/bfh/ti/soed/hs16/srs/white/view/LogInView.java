/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;


/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView extends AbstractView {
    // Controller of this View
    private LogInController logInController;

    // UI Components
    private TextField       fieldMail           = new TextField();
    private PasswordField fieldPassword       = new PasswordField();
    private Button btnLogin            = new Button("Log in");
    private Button          btnRegister         = new Button("Register");
    private Label labelMessage        = new Label("");

    public LogInView(){
        loadController();
    }

    @Override
    public Controller loadController() {
        logInController = new LogInController();

        logInController.setMailField(fieldMail);
        logInController.setPasswordField(fieldPassword);
        logInController.setMessageLabel(labelMessage);

        return logInController;
    }

    @Override
    public Component load() {
        final VerticalLayout formContainer = new VerticalLayout();
        formContainer.setStyleName("absolute-center");

        fieldMail.setCaption("Type your mail here:");
        fieldMail.setStyleName("textfield-form");

        fieldPassword.setCaption("Type your password here:");
        fieldPassword.setStyleName("textfield-form");

        btnLogin.addClickListener(e -> {
            logInController.login();
        });

        btnLogin.setStyleName("button-center");
        btnLogin.setWidth("91px");

        btnRegister.addClickListener(e -> {
            RegistrationView rView = new RegistrationView( this );
            rView.loadController();
            ApplicationController applicationController = ApplicationController.getInstance();
            applicationController.loadView( rView );
        });
        btnRegister.setStyleName("button-center");
        btnRegister.setWidth("91px");

        labelMessage.setStyleName("horizontal-center");
        labelMessage.setSizeUndefined();


        final HorizontalLayout layoutButtons = new HorizontalLayout();

        layoutButtons.addComponents(btnLogin, btnRegister);
        layoutButtons.setStyleName("horizontal-center");
        layoutButtons.setMargin(true);
        layoutButtons.setSpacing(true);

        formContainer.addComponents(fieldMail, fieldPassword, layoutButtons, labelMessage);
        formContainer.setMargin(true);
        formContainer.setSpacing(true);

        Responsive.makeResponsive(formContainer);

        return formContainer;
    }
}
