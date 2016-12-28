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
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.controller.AdminController;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import ch.bfh.ti.soed.hs16.srs.white.view.AdminView;
import com.vaadin.ui.*;

import javax.transaction.NotSupportedException;
import java.util.List;

/**
 * Created by arauzca on 24.12.16.
 */
public class UsersView extends AbstractTableView {
    private AbstractView parentView;

    public UsersView(AbstractView parentView) {
        super();
        this.parentView = parentView;
    }

    @Override
    public Controller loadController() {
        this.abstractTableController = new AbstractTableController() {
            EndUserModel endUserModel;

            @Override
            public void init() {
                endUserModel = EndUserModel.getInstance();
                endUserModel.loadModel();
            }

            @Override
            public List getData() {
                return endUserModel.getData();
            }

            @Override
            public boolean deleteData(int ID) {
                EndUser e = endUserModel.getEndUserById(ID);

                if (e == null) {
                    throw new NullPointerException("This ID returned no User");
                }

                return endUserModel.deleteUser(e);
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

    @Override
    public void changeContent(View newContent) {

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

            HorizontalLayout popupContent = new HorizontalLayout();
            popupContent.addComponent(new Label("Delete?"));

            Button deleteConfirm = new Button("OK");
            deleteConfirm.addClickListener(event -> {
                if (abstractTableController.deleteData(ID)) {
                    parentView.changeContent(new UsersView(parentView));
                }
            });

            popupContent.addComponent(deleteConfirm);
            popupContent.setSpacing(true);
            popupContent.setMargin(true);

            PopupView labelDelete = new PopupView(null, popupContent);
            labelDelete.setStyleName("delete-button");
            labelDelete.setVisible(true);

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
            throw new UnsupportedOperationException();
        }

        @Override
        public void changeContent(View newContent) {
            throw new UnsupportedOperationException();
        }
    }
}
