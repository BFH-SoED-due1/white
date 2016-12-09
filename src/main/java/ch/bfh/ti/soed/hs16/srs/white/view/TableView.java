/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view;


import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.entities.EndUserImpl;
import ch.bfh.ti.soed.hs16.srs.white.entities.RoomImpl;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;


/**
 * Created by joni on 30/11/16.
 */
public class TableView implements View {

    private HorizontalLayout layout = new HorizontalLayout();

    public HorizontalLayout createTable(){

        Table userTable = new Table("Users");
        Table roomTable = new Table("Room");
//        Table resTable = new Table("Reservation");

        userTable.addContainerProperty("ID", Integer.class, null);
        userTable.addContainerProperty("First Name", String.class, null);
        userTable.addContainerProperty("Last Name", String.class, null);
        userTable.addContainerProperty("Mail", String.class, null);

        EndUser e1 = new EndUserImpl((int)(Math.random() * 10000), "Anne", "Dreher", "ADreher@abc.ch");
        EndUser e2 = new EndUserImpl((int)(Math.random() * 10000), "Florian", "Koenig", "FKoenig@abc.ch");
        EndUser e3 = new EndUserImpl((int)(Math.random() * 10000), "Daniel", "Koehler", "DKoehler@abc.ch");
        EndUser e4 = new EndUserImpl((int)(Math.random() * 10000), "Philip", "Wagner", "PWagner@abc.ch");

        userTable.addItem(new Object[] {e1.getId(), e1.getFirstName(), e1.getLastName(), e1.getMail()}, new Integer(1));
        userTable.addItem(new Object[] {e2.getId(), e2.getFirstName(), e2.getLastName(), e2.getMail()}, new Integer(2));
        userTable.addItem(new Object[] {e3.getId(), e3.getFirstName(), e3.getLastName(), e3.getMail()}, new Integer(3));
        userTable.addItem(new Object[] {e4.getId(), e4.getFirstName(), e4.getLastName(), e4.getMail()}, new Integer(4));

        roomTable.addContainerProperty("ID", String.class, null);
        roomTable.addContainerProperty("#Seats", Integer.class, null);
        //table2.addContainerProperty("Reservation", Integer.class, null);


        Room r1 = new RoomImpl("N.521", 20);
        Room r2 = new RoomImpl("O.21", 20);
        Room r3 = new RoomImpl("332", 20);
        Room r4 = new RoomImpl("401", 20);

        roomTable.addItem(new Object[] {r1.getName(),r1.getQuantityOfSeats()}, new Integer(1));
        roomTable.addItem(new Object[] {r2.getName(),r2.getQuantityOfSeats()}, new Integer(2));
        roomTable.addItem(new Object[] {r3.getName(),r3.getQuantityOfSeats()}, new Integer(3));
        roomTable.addItem(new Object[] {r4.getName(),r4.getQuantityOfSeats()}, new Integer(4));


//        resTable.addContainerProperty("User", String.class, null);
//        resTable.addContainerProperty("Room", String.class, null);
//        resTable.addContainerProperty("Date", String.class, null);
//
//        Reservation res1 = new ReservationImpl();


        layout.addComponent(roomTable);
        layout.addComponent(userTable);

        return layout;
    }


    @Override
    public void load(UI ui) {

    }
}
