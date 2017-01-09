/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractTableView;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.View;
import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.model.EndUserModel;
import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

import java.sql.SQLException;
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
            private EndUserModel endUserModel;

            @Override
            public void init() {
                endUserModel = EndUserModel.getInstance();

                try {
                    endUserModel.loadModel();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public List getData() {
                return endUserModel.getData();
            }

            @Override
            public boolean deleteData(int ID) {
                EndUser e = endUserModel.getEndUserById(ID);
                boolean isDeleted = false;

                if (e == null) {
                    throw new NullPointerException("This ID returned no User");
                }

                try {
                    isDeleted = endUserModel.deleteUser(e);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return isDeleted;
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
    public Component createHeader() {
        GridLayout headerGrid = new GridLayout(4,1);
        headerGrid.setStyleName("table-parent");

        Label labelID = new Label("ID");
        labelID.setStyleName("display-table-header");
        Label labelFName = new Label("First Name");
        labelFName.setStyleName("display-table-header");
        Label labelLName = new Label("Last Name");
        labelLName.setStyleName("display-table-header");
        Label labelEMail = new Label("E-Mail");
        labelEMail.setStyleName("display-table-header");

        headerGrid.addComponent(labelID);
        headerGrid.addComponent(labelFName);
        headerGrid.addComponent(labelLName);
        headerGrid.addComponent(labelEMail);

        return headerGrid;
    }

    @Override
    public void changeContent(View newContent) {
        throw new UnsupportedOperationException();
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
            gridLayout.setStyleName("table-parent");

            Label labelID = new Label(Integer.toString(ID));
            labelID.setStyleName("display-table-cell");
            Label labelFName = new Label(fName);
            labelFName.setStyleName("display-table-cell");
            Label labelLName = new Label(lName);
            labelLName.setStyleName("display-table-cell");
            Label labelEmail = new Label(email);
            labelEmail.setStyleName("display-table-cell");

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
            gridLayout.setMargin(false);
            gridLayout.setSpacing(false);

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
