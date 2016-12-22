/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.controller.TableController;
import ch.bfh.ti.soed.hs16.srs.white.implementations.EndUserImpl;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;


/**
 * Created by hyamsj on 30/11/16.
 */
public class TableView extends AbstractView {
    private TableController tableController = new TableController();
    private HorizontalLayout layout = new HorizontalLayout();
    private Table userTable = new Table("Users");

    @Override
    public Component load() {


//        Table resTable = new Table("Reservation");

        userTable.addContainerProperty("ID", Integer.class, null);
        userTable.addContainerProperty("First Name", String.class, null);
        userTable.addContainerProperty("Last Name", String.class, null);
        userTable.addContainerProperty("Mail", String.class, null);

//        EndUser e1 = new EndUserImpl((int) (Math.random() * 10000), "Anne", "Dreher", "ADreher@abc.ch");
//        EndUser e2 = new EndUserImpl((int) (Math.random() * 10000), "Florian", "Koenig", "FKoenig@abc.ch");
//        EndUser e3 = new EndUserImpl((int) (Math.random() * 10000), "Daniel", "Koehler", "DKoehler@abc.ch");
//        EndUser e4 = new EndUserImpl((int) (Math.random() * 10000), "Philip", "Wagner", "PWagner@abc.ch");


//        userTable.addItem(new Object[]{e1.getId(), e1.getFirstName(), e1.getLastName(), e1.getMail()}, new Integer(1));
//        userTable.addItem(new Object[]{e2.getId(), e2.getFirstName(), e2.getLastName(), e2.getMail()}, new Integer(2));
//        userTable.addItem(new Object[]{e3.getId(), e3.getFirstName(), e3.getLastName(), e3.getMail()}, new Integer(3));
//        userTable.addItem(new Object[]{e4.getId(), e4.getFirstName(), e4.getLastName(), e4.getMail()}, new Integer(4));

        layout.addComponent(userTable);

        return layout;
    }

    @Override
    public Controller loadController() {
        tableController.setTable(userTable);
        return null;
    }

    @Override
    public void restart() {

    }
}
