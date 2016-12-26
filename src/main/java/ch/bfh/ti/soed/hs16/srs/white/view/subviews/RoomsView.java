/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.view.subviews;

import ch.bfh.ti.soed.hs16.srs.white.concept.Controller;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import ch.bfh.ti.soed.hs16.srs.white.controller.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.model.RoomModel;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

import java.util.List;

/**
 * Created by arauzca on 26.12.16.
 */
public class RoomsView extends AbstractTableView {
    @Override
    public Controller loadController() {
        this.abstractTableController = new AbstractTableController() {
            RoomModel roomModel;

            @Override
            public List getData() {
                return roomModel.getData();
            }

            @Override
            public void init() {
                roomModel = RoomModel.getInstance();
                roomModel.loadModel();
            }
        };

        return this.abstractTableController;
    }

    @Override
    public Component createItemView(Object o) {
        Room room = (Room) o;
        RoomView roomView = new RoomView(room.getId(), room.getName(), room.getQuantityOfSeats());

        return roomView.load();
    }

    private class RoomView extends AbstractView {
        private int ID;
        private String name;
        private int seatQuantity;

        public RoomView(int ID, String name, int seatQuantity) {
            this.ID = ID;
            this.name = name;
            this.seatQuantity = seatQuantity;
        }

        @Override
        public Component load() {
            GridLayout gridLayout = new GridLayout(3, 1);

            Label labelID = new Label(Integer.toString(ID));
            Label labelName = new Label(name);
            Label labelSeatQuantity = new Label(Integer.toString(seatQuantity));
            Label labelDelete = new Label();
            labelDelete.setStyleName("delete-button");

            gridLayout.addComponent(labelID);
            gridLayout.addComponent(labelName);
            gridLayout.addComponent(labelSeatQuantity);
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
