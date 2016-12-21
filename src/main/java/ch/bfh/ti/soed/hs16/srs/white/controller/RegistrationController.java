/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.MyUI;
import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import ch.bfh.ti.soed.hs16.srs.white.view.RegistrationView;

/**
 * Created by joni on 08/12/16.
 */
public class RegistrationController extends Controller {
    private RegistrationView regView;

    @Override
    public void init() {
    }

    public void register(){
      String fName = regView.getFirstName().getValue();
      String lName = regView.getLastName().getValue();
      String pass1 = regView.getPassword1().getValue();
      String pass2 = regView.getPassword2().getValue();

      if(pass1.equals(pass1)){
          regView.getLabel().setValue("Passwords match");
          //TODO database update
      }else{
          regView.getLabel().setValue("Password don't match");
      }
    }


}
