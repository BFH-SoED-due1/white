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
import ch.bfh.ti.soed.hs16.srs.white.helpers.ResourcesHelper;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.CustomMenuItem;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.UsersView;
import ch.bfh.ti.soed.hs16.srs.white.view.subviews.VerticalMenu;
import com.vaadin.ui.Button;
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

        VerticalMenu menuLayout = new VerticalMenu();
        menuLayout.setStyleName("menu-container");

        CustomMenuItem item1 = new CustomMenuItem("Users", "users");

        menuLayout.addComponent(item1);

        Button button = new Button();

        UsersView usersView = new UsersView();
        changeableContent = new VerticalLayout();
        changeContent(usersView);
        changeableContent.setStyleName("users-list");

        layout.addComponents(menuLayout, changeableContent);

        return layout;
    }

    @Override
    public Controller loadController() {
        adminController = new AdminController();
        adminController.setUpdatebleComponent(changeableContent);
        return adminController;
    }

    @Override
    public void restart() {

    }

    public void changeContent(View newContent) {
        changeableContent.removeAllComponents();
        changeableContent.addComponent(newContent.load());
    }
}
