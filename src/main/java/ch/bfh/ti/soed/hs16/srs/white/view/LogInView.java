/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractView;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import ch.bfh.ti.soed.hs16.srs.white.controller.LogInController;
import com.vaadin.event.ShortcutAction;
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
    private TextField fieldMail = new TextField();
    private PasswordField fieldPassword = new PasswordField();
    private Button btnLogin = new Button("Log in");
    private Button btnRegister = new Button("Register");
    private Label labelMessage = new Label("");

    public LogInView() {
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
    public void restart() {
        fieldMail.clear();
        fieldPassword.clear();
    }

    @Override
    public Component load() {
        final VerticalLayout formContainer = new VerticalLayout();
        formContainer.setStyleName("login-form");
        formContainer.setWidthUndefined();

        fieldMail.setCaption("Type your mail here:");
        fieldMail.setStyleName("textfield-form");
        fieldMail.setTabIndex(1);
        fieldMail.focus();

        fieldPassword.setCaption("Type your password here:");
        fieldPassword.setTabIndex(2);
        fieldPassword.setStyleName("textfield-form");

        btnLogin.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        btnLogin.setTabIndex(3);
        btnLogin.addClickListener(e -> {
            switch (logInController.login()) {
                case ADMIN:
                    AbstractView adminView = new AdminView();
                    ApplicationController appController = ApplicationController.getInstance();
                    appController.loadView(adminView);
                    break;
                case USER:
                    // Load the user view here
                default:
                    break;
            }
        });

        btnLogin.setStyleName("button-center");
        btnLogin.setTabIndex(4);
        btnLogin.setWidth("91px");

        btnRegister.addClickListener(e -> {
            RegistrationView rView = new RegistrationView(this);
            rView.loadController();
            ApplicationController applicationController = ApplicationController.getInstance();
            applicationController.loadView(rView);
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

    @Override
    public void changeContent(View newContent) {

    }
}
