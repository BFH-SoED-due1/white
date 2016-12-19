/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInView implements View {
    private LogInController loginController;                                            // Controller of this View

    // UI Components
    private TextField       mailField           = new TextField();
    private PasswordField   passwordField       = new PasswordField();
    private Button          loginButton         = new Button("Log in");
    private Button          registerButton      = new Button("Register");
    private Label           messageLabel        = new Label("");
    private Label           footer              = FooterView.getInstance();
    private FileResource    resource;

    public LogInView(LogInController logInController){
        this.loginController    = logInController;
        String basepath         = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        resource                = new FileResource(new File(basepath + "/images/uite_logo.png"));

        loginController.mailField       = this.mailField;
        loginController.passwordField   = this.passwordField;
        loginController.loginButton     = this.loginButton;
        loginController.registerButton  = this.registerButton;
        loginController.messageLabel    = this.messageLabel;
    }

    @Override
    public void load(UI ui) {

        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("login-form");

        final VerticalLayout formContainer = new VerticalLayout();
        formContainer.setStyleName("absolute-center");

        Image imageLogo = new Image("", resource);
        imageLogo.setStyleName("logo-corner-300");

        mailField.setCaption("Type your mail here:");
        mailField.setStyleName("textfield-form");

        passwordField.setCaption("Type your password here:");
        passwordField.setStyleName("textfield-form");

        loginButton.addClickListener(e -> {
            loginController.login();
        });
        loginButton.setStyleName("button-center");
        loginButton.setWidth("91px");

        registerButton.addClickListener(e -> {
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

        layout.addComponents(imageLogo, formContainer, footer);
        layout.setMargin(true);
        layout.setSpacing(true);

        ui.setContent(layout);

    }
}
