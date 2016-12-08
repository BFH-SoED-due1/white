/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.view.LogInView;
import com.vaadin.ui.*;

/**
 * Created by arauzca on 25.10.16.
 */
public class LogInController {
    private UI myUI;
    private LogInView logInView;

    public LogInController(UI mainUI) {
        this.myUI = mainUI;
        logInView = new LogInView(this);
    }

    public void loadView() {
        logInView.load(myUI);
    }


    /*public void getLogin(TextField mail, PasswordField password){
        String n = mail.getValue();
        String p = password.getValue();
        System.out.println(n); //for testing purposes
        System.out.println(p); //for testing purposes

    }*/

    public void login(){
        String pw = logInView.getPasswordField().getValue();
        String mail = logInView.getMailField().getValue();

        //TODO needs model to compare login data with the database

        if (pw.equals("123")  && mail.equals("mail@bfh.ch")){
            logInView.getMessageLabel().setValue("Login successful");
            // TODO creates new view
            //myUI.setContent(new TableView().createTable());
            // eg. loadTableView()
        }else{
            logInView.getMessageLabel().setValue("Login incorrect");
        }


    }




}
