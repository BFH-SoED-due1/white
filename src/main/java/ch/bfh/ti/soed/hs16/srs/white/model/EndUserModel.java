/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.concept.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arauzca on 21.10.16.
 */
public class EndUserModel implements Model {
    private List<EndUser> endUsers = new ArrayList<>();;
    private Connection connection;

    public EndUserModel(Connection connection) {
        this.connection = connection;
    }

    public List<EndUser> getEndUsers() {
        return endUsers;
    }

    public boolean loadModel() {
        boolean b = false;
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM enduser")) {
            b = ps.execute();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println( rs.getString(2) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    public List getData() {
        return endUsers;
    }

    public void addData(Object o) {
        EndUser user = (EndUser) o;
        endUsers.add(user);
    }

    public static boolean testConnection() {
        boolean value = true;
        String protocol = "jdbc:derby:/Users/arauzca/Workspace/white/src/main/resources/ReservationSystem;user=sed_while;password=sedhs2016";

        try {
            Connection conn = DriverManager.getConnection(protocol);
            if (conn == null) {
                value = false;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            value = false;
        }

        return value;
    }

    /*public void deleteEndUserById(Integer id) {
        endUsers.remove(id);
    }

    public EndUser getEndUserById(Integer id) {
        EndUser e = endUsers.getOrDefault(id, null);
        return e;
    }*/

    public void saveUsers() {
    }
}
