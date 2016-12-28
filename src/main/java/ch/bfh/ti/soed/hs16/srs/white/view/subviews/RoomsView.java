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
import ch.bfh.ti.soed.hs16.srs.white.concept.View;
import ch.bfh.ti.soed.hs16.srs.white.controller.AbstractTableController;
import ch.bfh.ti.soed.hs16.srs.white.model.RoomModel;
import ch.bfh.ti.soed.hs16.srs.white.view.AbstractView;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by arauzca on 26.12.16.
 */
public class RoomsView extends AbstractTableView {
    private AbstractView parentView;

    public RoomsView(AbstractView parentView) {
        super();
        this.parentView = parentView;
    }

    @Override
    public Controller loadController() {
        this.abstractTableController = new AbstractTableController() {
            RoomModel roomModel;

            @Override
            public void init() {
                roomModel = RoomModel.getInstance();
                roomModel.loadModel();
            }

            @Override
            public List getData() {
                return roomModel.getData();
            }

            @Override
            public boolean deleteData(int ID) {
                return false;
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

    @Override
    public void changeContent(View newContent) {

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
            GridLayout gridLayout = new GridLayout(4, 1);

            Label labelID = new Label(Integer.toString(ID));
            Label labelName = new Label(name);
            Label labelSeatQuantity = new Label(Integer.toString(seatQuantity));

            HorizontalLayout popupContent = new HorizontalLayout();
            popupContent.addComponent(new Label("Delete?"));

            Button deleteConfirm = new Button("OK");
            deleteConfirm.addClickListener(event -> {
                if (abstractTableController.deleteData(ID)) {
                    parentView.changeContent(new RoomsView(parentView));
                }
            });

            popupContent.addComponent(deleteConfirm);
            popupContent.setSpacing(true);
            popupContent.setMargin(true);

            PopupView labelDelete = new PopupView(null, popupContent);
            labelDelete.setStyleName("delete-button");
            labelDelete.setVisible(true);

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

        @Override
        public void changeContent(View newContent) {

        }
    }
}
