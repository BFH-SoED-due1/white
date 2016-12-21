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
import com.vaadin.ui.*;

/**
 * Created by joni on 04/12/16.
 */
public class RegistrationView extends View {
    private VerticalLayout layout = new VerticalLayout();
    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private PasswordField password1 = new PasswordField("Password");
    private PasswordField password2 = new PasswordField("Repeat Password");
    private Button submit = new Button("Submit");
    private Label label = new Label();

    @Override
    public Component load() {
        layout.addComponents(firstName, lastName, password1, password2, submit, label);

        return layout;
    }

    @Override
    public Controller loadController() {
        return null;
    }


    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastName() {
        return lastName;
    }

    public PasswordField getPassword1() {
        return password1;
    }

    public PasswordField getPassword2() {
        return password2;
    }

    public Button getSubmit() {
        return submit;
    }

    public Label getLabel() {
        return label;
    }

}
