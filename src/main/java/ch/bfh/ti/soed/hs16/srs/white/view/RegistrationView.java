/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.RegistrationController;
import com.vaadin.ui.*;


/**
 * Created by hyamsj on 04/12/16.
 */
public class RegistrationView extends AbstractView {
    private RegistrationController registrationController = new RegistrationController();
    private TextField fieldFirstName = new TextField("First Name");
    private TextField fieldLastName = new TextField("Last Name");
    private TextField fieldEmail = new TextField("E-Mail Address");
    private TextField fieldConfirmEmail = new TextField("Repeat E-Mail Address");
    private PasswordField fieldPassword = new PasswordField("Password");
    private PasswordField fieldConfirmPassword = new PasswordField("Repeat Password");
    private Button btnSubmit = new Button("Submit");
    private Button btnCancel = new Button("Cancel");
    private Label labelMessage = new Label();

    public RegistrationView(AbstractView lastView) {
        super(lastView);
    }

    @Override
    public Component load() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("absolute-center");

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
        registrationController.setMyView(this);
        registrationController.setFieldFirstName(fieldFirstName);
        registrationController.setFieldLastName(fieldLastName);
        registrationController.setFieldEmail(fieldEmail);
        registrationController.setFieldConfirmEmailEmail(fieldConfirmEmail);
        registrationController.setFieldPassword(fieldPassword);
        registrationController.setFieldConfirmPassword(fieldConfirmPassword);
        registrationController.setLabelMessage(labelMessage);

        return null;
    }

    @Override
    public void restart() {
        fieldFirstName.clear();
        fieldLastName.clear();
        fieldEmail.clear();
        fieldPassword.clear();
        fieldConfirmPassword.clear();
    }

}
