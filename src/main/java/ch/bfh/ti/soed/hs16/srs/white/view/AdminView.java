/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.AdminController;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.CustomMenuItem;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.RoomsView;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.UsersView;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.VerticalMenu;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by arauzca on 24.12.16.
 */
public class AdminView extends AbstractView {
    private AdminController adminController;
    private VerticalLayout changeableContent;

    @Override
    public Component load() {
        HorizontalLayout layout = new HorizontalLayout();
        UsersView usersView = new UsersView(this);
        RoomsView roomsView = new RoomsView(this);

        usersView.loadController();
        roomsView.loadController();

        VerticalMenu menuLayout = new VerticalMenu();
        menuLayout.setStyleName("menu-container");

        CustomMenuItem item1 = new CustomMenuItem("Users", "users");
        item1.addClickListener(event -> changeContent(usersView));

        CustomMenuItem item2 = new CustomMenuItem("Rooms", null);
        item2.addClickListener(event -> changeContent(roomsView));

        menuLayout.addMenuItem(item1);
        menuLayout.addMenuItem(item2);

        changeableContent = new VerticalLayout();
        changeContent(usersView);
        changeableContent.setStyleName("changeable-container");
        changeableContent.setResponsive(true);

        layout.addComponents(menuLayout, changeableContent);

        return layout;
    }

    @Override
    public Controller loadController() {
        adminController = new AdminController();
        adminController.setUpdatableComponent(changeableContent);
        return adminController;
    }

    @Override
    public void restart() {

    }

    @Override
    public void changeContent(View newContent) {
        changeableContent.removeAllComponents();
        changeableContent.addComponent(newContent.load());
    }
}
