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
import ch.bfh.ti.soed.hs16.srs.white.implementations.EndUserImpl;

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
    private DbConnection myconn;
    private List<EndUser> endUsers = new ArrayList<>();

    public static EndUserModel getInstance() {
        if (uniqueModel == null) {
            uniqueModel = new EndUserModel();
        }

        return uniqueModel;
    }

    private EndUserModel() {
        myconn = DbConnection.getInstance();
    }

    protected List<EndUser> getEndUsers() {
        return endUsers;
    }

    public boolean loadModel() {
        Connection connection;
        PreparedStatement ps;

        boolean b = false;

        try {
            connection = myconn.getConnection();
            ps = connection.prepareStatement("SELECT * FROM enduser");
            b = ps.execute();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(rs.findColumn("ID"));
                String fName = rs.getString(rs.findColumn("FNAME"));
                String lName = rs.getString(rs.findColumn("LNAME"));
                String mail = rs.getString(rs.findColumn("EMAIL"));
                EndUser endUser = new EndUserImpl(id, fName, lName, mail);
                endUsers.add(endUser);
                System.out.println(endUser);


            }

            ps.close();
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

    public boolean saveUser(EndUser u) {
        return false;
    }

    public boolean checkLogin(String email, String password) {
        Connection connection;
        PreparedStatement ps;

        try {
            connection = myconn.getConnection();
            ps = connection.prepareStatement("SELECT PASSWORD FROM ENDUSER WHERE EMAIL = ?");
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            if (email.isEmpty()) return false;
            if (password.isEmpty()) return false;
            if (resultSet == null) return false;

            resultSet.next();
            int column = resultSet.findColumn("PASSWORD");
            String databasePW = resultSet.getString(column);

            ps.close();

            if (!password.equals(databasePW)) return false;
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
