/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.ApplicationController;
import ch.bfh.ti.soed.hs16.srs.white.controller.UserTableController;
import com.vaadin.ui.*;


/**
 * Created by hyamsj on 30/11/16.
 */
public class UserTableView extends AbstractView {
    private UserTableController userTableController;
    private VerticalLayout layout = new VerticalLayout();
    private Table userTable = new Table("Users");
    private Button btnRooms = new Button("Rooms");
    private Button btnLogout = new Button("Logout");

    @Override
    public Component load() {
        btnLogout.addClickListener(e -> {
            LogInView lView = new LogInView();
            lView.loadController();
            userTableController.goBack(lView);
        });

        btnRooms.addClickListener(e -> {
            RoomView rView = new RoomView(this);
            rView.loadController();
            ApplicationController appCon = ApplicationController.getInstance();
            appCon.loadView(rView);
        });

        userTable.addContainerProperty("ID", Integer.class, null);
        userTable.addContainerProperty("First Name", String.class, null);
        userTable.addContainerProperty("Last Name", String.class, null);
        userTable.addContainerProperty("Mail", String.class, null);

        userTableController.loadTable();

        layout.addComponents(userTable, btnRooms, btnLogout);
        return layout;
    }

    @Override
    public Controller loadController() {
        userTableController = new UserTableController();
        userTableController.setTable(userTable);

        return userTableController;
    }

    @Override
    public void restart() {

    }
}
