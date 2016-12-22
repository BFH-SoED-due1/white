/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.controller.RoomController;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by hyamsj on 22/12/16.
 */
public class RoomView extends AbstractView{
    private RoomController roomController;
    private VerticalLayout layout = new VerticalLayout();
    private Table roomTable = new Table("Rooms");
    private Button btnBack = new Button("Go back");
    private Button btnLogout = new Button("Logout");

    public RoomView(AbstractView lastView){
        super(lastView);
    }

    @Override
    public Component load() {
        btnLogout.addClickListener(e -> {
            LogInView lView = new LogInView();
            lView.loadController();
            roomController.goBack(lView);
        });
        roomTable.addContainerProperty("ID", Integer.class, null);
        roomTable.addContainerProperty("Name", String.class, null);
        roomTable.addContainerProperty("Seats", Integer.class, null);

        btnBack.addClickListener(e -> roomController.goBack(getLastView()));
        roomController.loadTable();
        layout.addComponents(roomTable, btnBack, btnLogout);
        return layout;
    }

    @Override
    public Controller loadController() {
        roomController = new RoomController();
        roomController.setTable(roomTable);
        return roomController;
    }

    @Override
    public void restart() {

    }
}
