/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractController;
import ch.bfh.ti.soed.hs16.srs.white.concept.Right;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import java.sql.SQLException;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController extends AbstractController {
    private EndUserModel endUserModel;

    // UI Components of the View
    private TextField mailField;
    private PasswordField passwordField;
    private Label messageLabel;

    @Override
    public void init() {
        this.endUserModel = EndUserModel.getInstance();
    }

    public Right login() {
        String mail = mailField.getValue();
        String pw = passwordField.getValue();

        if (mail.isEmpty() && pw.isEmpty()) {
            messageLabel.setValue("Please enter your e-mail address and your password to log in");
        } else if (mail.isEmpty()) {
            messageLabel.setValue("Please enter your e-mail address");
        } else if (pw.isEmpty()) {
            messageLabel.setValue("Please enter your password");
        } else {
            try {
                if (endUserModel.checkLogin(mail, pw)) {
                    messageLabel.setValue("Login Successful");

                    if (mail.equals("admin")) return Right.ADMIN;
                    else return Right.USER;
                } else {
                    messageLabel.setValue("Login Failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Right.NOTUSER;
    }

    public void setMailField(TextField mailField) {
        this.mailField = mailField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }


}
