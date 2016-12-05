/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

/**
 * Created by joni on 04/12/16.
 */
public class RegistrationView {

    private VerticalLayout layout = new VerticalLayout();


    public VerticalLayout register() {
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        PasswordField password = new PasswordField("Password");
        PasswordField password2 = new PasswordField("Repeat Password");


        Button submit = new Button("Submit");
        Label label = new Label();
        submit.addClickListener(e -> {
            if(password.getValue().contentEquals(password2.getValue())) {
                label.setValue("Data has been sent");
            }else{
                label.setValue("Passwords don't match");
            }
        });

        layout.addComponents(firstName, lastName, password, password2, submit, label);
        return layout;
    }
}
