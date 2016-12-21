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
 * Created by joni on 08/12/16.
 */
public class RegistrationController extends AbstractController {
    private TextField firstName;
    private TextField lastName;
    private PasswordField password1;
    private PasswordField password2;
    private Label label;

    public void setFirstName(TextField firstName) {
        this.firstName = firstName;
    }

    public void setLastName(TextField lastName) {
        this.lastName = lastName;
    }

    public void setPassword1(PasswordField password1) {
        this.password1 = password1;
    }

    public void setPassword2(PasswordField password2) {
        this.password2 = password2;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public void init() {

    }

    public void register(){
      String fName = firstName.getValue();
      String lName = lastName.getValue();
      String pass1 = password1.getValue();
      String pass2 = password2.getValue();
      if((pass1.isEmpty()) || (pass2.isEmpty())){ label.setValue("Password can't be empty");
      } else if(pass1.equals(pass2)){
          label.setValue("Passwords match");
          //TODO database update
      }else{
          label.setValue("Password don't match");
      }
    }


}
