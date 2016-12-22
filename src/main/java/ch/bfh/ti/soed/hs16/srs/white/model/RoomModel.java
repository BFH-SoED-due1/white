/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.Model;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;
import ch.bfh.ti.soed.hs16.srs.white.implementations.RoomImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyamsj on 22/12/16.
 */
public class RoomModel implements Model {
    private static RoomModel uniqueModel;
    private DbConnection myconn;
    private List<Room> rooms = new ArrayList<>();

    public static RoomModel getInstance() {
        if (uniqueModel == null) {
            uniqueModel = new RoomModel();
        }
        return uniqueModel;
    }

    private RoomModel(){
        myconn = DbConnection.getInstance();
    }

    public List<Room> getRooms(){
        return rooms;
    }

    @Override
    public boolean loadModel() {
        Connection connection;
        PreparedStatement ps;

        boolean b = false;

        try {
            connection = myconn.getConnection();
            ps = connection.prepareStatement("SELECT * FROM room");
            b = ps.execute();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(rs.findColumn("ID"));
                String name = rs.getString(rs.findColumn("NAME"));
                int seats = rs.getInt(rs.findColumn("SEAT_QUANTITY"));
                Room room = new RoomImpl(id, name, seats);
                rooms.add(room);


            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    @Override
    public List getData() {
        return rooms;
    }

    @Override
    public void addData(Object o) {
        Room room = (Room) o;
        rooms.add(room);
    }
}
