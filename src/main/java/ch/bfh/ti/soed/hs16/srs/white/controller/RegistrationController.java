/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractController;
import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractView;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import javax.naming.OperationNotSupportedException;

/**
 * Created by hyamsj on 08/12/16.
 */
public class RegistrationController extends AbstractController {
    private EndUserModel endUserModel;

    private TextField fieldFirstName;
    private TextField fieldLastName;
    private TextField fieldEmail;
    private TextField fieldConfirmEmail;
    private PasswordField fieldPassword;
    private PasswordField fieldConfirmPassword;
    private Label labelMessage;

    @Override
    public void init() {
        endUserModel = EndUserModel.getInstance();
    }

    public void register() {
        String fName = fieldFirstName.getValue();
        String lName = fieldLastName.getValue();
        String eMail = fieldEmail.getValue();
        String confirmEMail = fieldConfirmEmail.getValue();
        String pass1 = fieldPassword.getValue();
        String pass2 = fieldConfirmPassword.getValue();
        boolean submit = true;

        if (fName.isEmpty()) {
            fieldFirstName.setInputPrompt("Can't be empty");
            submit = false;
        }

        if (lName.isEmpty()) {
            fieldLastName.setInputPrompt("Can't be empty");
            submit = false;
        }

        if (eMail.isEmpty()) {
            fieldEmail.setInputPrompt("Can't be empty");
            submit = false;
        }

        if (confirmEMail.isEmpty()) {
            fieldConfirmEmail.setInputPrompt("Can't be empty");
            submit = false;
        }

        if ((pass1.isEmpty()) || (pass2.isEmpty())) {
            labelMessage.setValue("Password can't be empty");
            submit = false;
        }

        if (!eMail.equals(confirmEMail)) {
            labelMessage.setValue("E-Mail addresses don't match");
            submit = false;
        }

        if (!pass1.equals(pass2)) {
            labelMessage.setValue("Password don't match");
            submit = false;
        }

        if (submit) {
            if (endUserModel.saveUser(fName, lName, eMail, pass1)) {
                labelMessage.setValue("User created");

                if( myView.getLastView() != null)
                    goBack(myView.getLastView());
                else
                    labelMessage.setValue("no last view");
            } else {
                labelMessage.setValue("There was an error trying to create a new user, please try again and/or change your e-mail address.");
            }
        }
    }

    public void setFieldFirstName(TextField fieldFirstName) {
        this.fieldFirstName = fieldFirstName;
    }

    public void setFieldLastName(TextField fieldLastName) {
        this.fieldLastName = fieldLastName;
    }

    public void setFieldEmail(TextField fieldEmail) {
        this.fieldEmail = fieldEmail;
    }

    public void setFieldConfirmEmailEmail(TextField fieldConfirmEmail) {
        this.fieldConfirmEmail = fieldConfirmEmail;
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

    public void goBack(AbstractView lastView) {
        try {
            lastView.restart();
            ApplicationController applicationController = ApplicationController.getInstance();
            applicationController.loadView(lastView);
        } catch (OperationNotSupportedException ex) {
            System.out.println("Restart method not implemented.");
        }
    }

}
