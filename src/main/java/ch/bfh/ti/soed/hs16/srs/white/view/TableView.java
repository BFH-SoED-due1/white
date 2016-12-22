/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.TableController;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;


/**
 * Created by hyamsj on 30/11/16.
 */
public class TableView extends AbstractView {
    private TableController tableController;
    private HorizontalLayout layout = new HorizontalLayout();
    private Table userTable = new Table("Users");

    @Override
    public Component load() {

        userTable.addContainerProperty("ID", Integer.class, null);
        userTable.addContainerProperty("First Name", String.class, null);
        userTable.addContainerProperty("Last Name", String.class, null);
        userTable.addContainerProperty("Mail", String.class, null);

        tableController.loadTable();

        layout.addComponent(userTable);

        return layout;
    }

    @Override
    public Controller loadController() {
        tableController = new TableController();
        tableController.setTable(userTable);

        return tableController;
    }

    @Override
    public void restart() {

    }
}
