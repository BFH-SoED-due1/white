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
import ch.bfh.ti.soed.hs16.srs.white.controller.RegistrationController;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;


/**
 * Created by hyamsj on 04/12/16.
 */
public class RegistrationView extends AbstractView {
    private RegistrationController registrationController;
    private TextField fieldFirstName;
    private TextField fieldLastName;
    private TextField fieldEmail;
    private TextField fieldConfirmEmail;
    private PasswordField fieldPassword;
    private PasswordField fieldConfirmPassword;
    private Button btnSubmit;
    private Button btnCancel;
    private Label labelMessage;

    public RegistrationView(AbstractView lastView) {
        super(lastView);
        fieldFirstName = new TextField("First Name");
        fieldLastName = new TextField("Last Name");
        fieldEmail = new TextField("E-Mail Address");
        fieldConfirmEmail = new TextField("Repeat E-Mail Address");
        fieldPassword = new PasswordField("Password");
        fieldConfirmPassword = new PasswordField("Repeat Password");
        btnSubmit = new Button("Submit");
        btnCancel = new Button("Cancel");
        labelMessage = new Label();
        loadController();
    }

    @Override
    public Component load() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("registration-form");

        fieldFirstName.setStyleName("textfield-form");
        fieldLastName.setStyleName("textfield-form");
        fieldEmail.setStyleName("textfield-form");
        fieldConfirmEmail.setStyleName("textfield-form");
        fieldPassword.setStyleName("textfield-form");
        fieldConfirmPassword.setStyleName("textfield-form");

        btnSubmit.setStyleName("button-center");
        btnSubmit.setWidth("91px");
        btnSubmit.addClickListener(e -> registrationController.register());

        btnCancel.setStyleName("button-center");
        btnCancel.setWidth("91px");
        btnCancel.addClickListener(e -> registrationController.goBack(getLastView()));

        final HorizontalLayout layoutButtons = new HorizontalLayout();
        layoutButtons.addComponents(btnSubmit, btnCancel);
        layoutButtons.setStyleName("horizontal-center");
        layoutButtons.setMargin(true);
        layoutButtons.setSpacing(true);

        labelMessage.setStyleName("horizontal-center");
        labelMessage.setSizeUndefined();

        layout.addComponents(fieldFirstName, fieldLastName, fieldEmail, fieldConfirmEmail, fieldPassword, fieldConfirmPassword, layoutButtons, labelMessage);

        return layout;
    }

    @Override
    public Controller loadController() {
        registrationController = new RegistrationController();
        registrationController.setMyView(this);
        registrationController.setFieldFirstName(this.fieldFirstName);
        registrationController.setFieldLastName(this.fieldLastName);
        registrationController.setFieldEmail(this.fieldEmail);
        registrationController.setFieldConfirmEmailEmail(this.fieldConfirmEmail);
        registrationController.setFieldPassword(this.fieldPassword);
        registrationController.setFieldConfirmPassword(this.fieldConfirmPassword);
        registrationController.setLabelMessage(this.labelMessage);

        return registrationController;
    }

    @Override
    public void restart() {
        fieldFirstName.clear();
        fieldLastName.clear();
        fieldEmail.clear();
        fieldPassword.clear();
        fieldConfirmPassword.clear();
    }

    @Override
    public void changeContent(View newContent) {

    }

}
