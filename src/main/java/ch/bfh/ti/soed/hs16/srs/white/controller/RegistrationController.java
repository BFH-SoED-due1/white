/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * Created by hyamsj on 08/12/16.
 */
public class RegistrationController extends AbstractController {
    private TextField fieldFirstName;
    private TextField fieldLastName;
    private PasswordField fieldPassword;
    private PasswordField fieldConfirmPassword;
    private Label labelMessage;

    @Override
    public void init() {
    }

    public void register() {
        String fName = fieldFirstName.getValue();
        String lName = fieldLastName.getValue();
        String pass1 = fieldPassword.getValue();
        String pass2 = fieldConfirmPassword.getValue();
        if ((pass1.isEmpty()) || (pass2.isEmpty())) {
            labelMessage.setValue("Password can't be empty");
        } else if (pass1.equals(pass2)) {
            labelMessage.setValue("Passwords match");
            //TODO database update
        } else {
            labelMessage.setValue("Password don't match");
        }
    }

    public void setFieldFirstName(TextField fieldFirstName) {
        this.fieldFirstName = fieldFirstName;
    }

    public void setFieldLastName(TextField fieldLastName) {
        this.fieldLastName = fieldLastName;
    }

    public void setFieldPassword(PasswordField fieldPassword) {
        this.fieldPassword = fieldPassword;
    }

    public void setFieldConfirmPassword(PasswordField fieldConfirmPassword) {
        this.fieldConfirmPassword = fieldConfirmPassword;
    }

    public void setLabelMessage(Label labelMessage) {
        this.labelMessage = labelMessage;
    }

}
