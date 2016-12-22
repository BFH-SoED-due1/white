/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.controller;

import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import ch.bfh.ti.soed.hs16.srs.white.model.RoomModel;
import com.vaadin.ui.Table;

import java.util.List;

/**
 * Created by hyamsj on 22/12/16.
 */
public class RoomController extends AbstractController{
    private Table table;
    private RoomModel roomModel;

    public void setTable(Table table){
        this.table = table;
    }
    @Override
    public void init() {
        roomModel = RoomModel.getInstance();
        roomModel.loadModel();
    }

    public void loadTable(){
        List<Room> rooms = roomModel.getRooms();
        rooms.forEach(e -> {
            table.addItem(new Object[]{e.getId(), e.getName(), e.getQuantityOfSeats()}, null);
        });
    }

}
