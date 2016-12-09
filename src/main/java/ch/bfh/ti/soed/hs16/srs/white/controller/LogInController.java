/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController implements Controller {
    private UI ui;
    private View logInView;
    private EndUserModel endUserModel;

    public LogInController(UI ui) {
        this.ui             = ui;
        this.endUserModel   = EndUserModel.getInstance();
    }

    @Override
    public void init() {
        logInView = new LogInView(this);
    }

    @Override
    public void loadView() {
        logInView.load(ui);
    }


    /*public void getLogin(TextField mail, PasswordField password){
        String n = mail.getValue();
        String p = password.getValue();
        System.out.println(n); //for testing purposes
        System.out.println(p); //for testing purposes

    }*/

    public void login(String mail, String pw, Label messageLabel) {
        if (endUserModel.checkLogin(mail, pw)){
            messageLabel.setValue("Login successful");
            // TODO creates new view
            //myUI.setContent(new TableView().createTable());
            // eg. loadTableView()
        }else{
            messageLabel.setValue("Login incorrect");
        }


    }




}
