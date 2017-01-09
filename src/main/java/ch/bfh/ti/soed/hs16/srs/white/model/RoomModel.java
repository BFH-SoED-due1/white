/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractModel;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.Room;
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;
import ch.bfh.ti.soed.hs16.srs.white.implementations.RoomImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by hyamsj on 22/12/16.
 */
public class RoomModel extends AbstractModel {
    private static RoomModel uniqueModel;
    private DbConnection myconn;

    public static RoomModel getInstance() {
        if (uniqueModel == null) {
            uniqueModel = new RoomModel();
        }
        return uniqueModel;
    }

    private RoomModel() {
        data = new ArrayList<Room>();

        try {
            myconn = DbConnection.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean loadModel() throws SQLException {
        Connection connection;
        PreparedStatement ps;

        boolean b = false;
        data.clear();

        connection = myconn.getConnection();
        ps = connection.prepareStatement("SELECT * FROM room");
        b = ps.execute();

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(rs.findColumn("ID"));
            String name = rs.getString(rs.findColumn("NAME"));
            int seats = rs.getInt(rs.findColumn("SEAT_QUANTITY"));
            Room room = new RoomImpl(id, name, seats);
            data.add(room);
        }

        ps.close();

        return b;
    }

    @Override
    public void addData(Object o) {
        Room room = (Room) o;
        data.add(room);
    }
}
