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
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arauzca on 21.10.16.
 */
public class EndUserModel implements Model {
    private static EndUserModel uniqueModel;
    private List<EndUser> endUsers = new ArrayList<>();;
    private Connection connection;

    public static EndUserModel getInstance() {
        if (uniqueModel == null) {
            uniqueModel = new EndUserModel();
        }

        return uniqueModel;
    }

    private EndUserModel() {
        this.connection = DbConnection.getInstance();
    }

    protected List<EndUser> getEndUsers() {
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

    /*public void deleteEndUserById(Integer id) {
        endUsers.remove(id);
    }

    public EndUser getEndUserById(Integer id) {
        EndUser e = endUsers.getOrDefault(id, null);
        return e;
    }*/

    public boolean saveUser(EndUser u) {
        return false;
    }

    public boolean checkLogin(String email, String password){
        try (PreparedStatement ps = connection.prepareStatement("SELECT PASSWORD FROM ENDUSER WHERE EMAIL = ?")) {
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet == null) return false;

            resultSet.next();
            String databasePW = resultSet.getString(1);

            if (!password.equals(databasePW)) return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
