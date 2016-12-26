/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.controller.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.controller.AdminController;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by arauzca on 24.12.16.
 */
public class UsersView extends AbstractTableView {

    @Override
    public Controller loadController() {
        this.abstractTableController = new AbstractTableController() {
            EndUserModel endUserModel;

            @Override
            public List getData() {
                return endUserModel.getData();
            }

            @Override
            public void init() {
                endUserModel = EndUserModel.getInstance();
                endUserModel.loadModel();
            }
        };

        return this.abstractTableController;
    }

    @Override
    public Component createItemView(Object o) {
        EndUser endUser = (EndUser) o;
        UserView userView = new UserView(endUser.getId(), endUser.getFirstName(), endUser.getLastName(), endUser.getMail());

        return userView.load();
    }

    private class UserView extends AbstractView {
        private int ID;
        private String lName;
        private String fName;
        private String email;

        public UserView(int ID, String fName, String lName, String email) {
            this.ID = ID;
            this.fName = fName;
            this.lName = lName;
            this.email = email;
        }

        @Override
        public Component load() {
            GridLayout gridLayout = new GridLayout(5, 1);

            Label labelID = new Label(Integer.toString(ID));
            Label labelFName = new Label(fName);
            Label labelLName = new Label(lName);
            Label labelEmail = new Label(email);
            Label labelDelete = new Label();
            labelDelete.setStyleName("delete-button");

            gridLayout.addComponent(labelID);
            gridLayout.addComponent(labelFName);
            gridLayout.addComponent(labelLName);
            gridLayout.addComponent(labelEmail);
            gridLayout.addComponent(labelDelete);

            return gridLayout;
        }

        @Override
        public Controller loadController() {
            return null;
        }

        @Override
        public void restart() {

        }
    }
}