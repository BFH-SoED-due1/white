/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.RegistrationController;
import com.vaadin.ui.*;

/**
 * Created by joni on 04/12/16.
 */
public class RegistrationView implements View {
    private RegistrationController regController;
    private VerticalLayout layout = new VerticalLayout();
    private TextField firstName = new TextField("First Name");
    private TextField lastName = new TextField("Last Name");
    private PasswordField password1 = new PasswordField("Password");
    private PasswordField password2 = new PasswordField("Repeat Password");
    private Button submit = new Button("Submit");
    private Label label = new Label();


    public RegistrationView(RegistrationController regController){
        this.regController = regController;
    }

    @Override
    public void load(UI ui) {
        layout.addComponents(firstName, lastName, password1, password1, submit, label);
        ui.setContent(layout);
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
