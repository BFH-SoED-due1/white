/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.AbstractModel;
import ch.bfh.ti.soed.hs16.srs.white.concept.interfaces.EndUser;
import ch.bfh.ti.soed.hs16.srs.white.helpers.DbConnection;
import ch.bfh.ti.soed.hs16.srs.white.implementations.EndUserImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arauzca on 21.10.16.
 */
public class EndUserModel extends AbstractModel {
    private static EndUserModel uniqueModel;
    private DbConnection myconn;

    public static EndUserModel getInstance() {
        if (uniqueModel == null) {
            uniqueModel = new EndUserModel();
        }

        return uniqueModel;
    }

    private EndUserModel() {
        data = new ArrayList<EndUser>();

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
        ps = connection.prepareStatement("SELECT * FROM enduser ORDER BY ID");
        b = ps.execute();

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(rs.findColumn("ID"));
            String fName = rs.getString(rs.findColumn("FNAME"));
            String lName = rs.getString(rs.findColumn("LNAME"));
            String mail = rs.getString(rs.findColumn("EMAIL"));
            EndUser endUser = new EndUserImpl(id, fName, lName, mail);
            data.add(endUser);


        }

        ps.close();

        return b;
    }

    @Override
    public void addData(Object o) {
        EndUser user = (EndUser) o;
        data.add(user);
    }

    public EndUser getEndUserById(int ID) {
        List<EndUser> endUserList = (List<EndUser>) uniqueModel.getData();
        EndUser wantedEndUser = null;

        for (EndUser e : endUserList) {
            if (e.getId() == ID) {
                wantedEndUser = e;
                break;
            }
        }

        return wantedEndUser;
    }

    public boolean saveUser(String fName, String lName, String eMail, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        int id;
        boolean result;

        try {
            connection = myconn.getConnection();
            id = getNotUsedID(connection);

            preparedStatement = connection.prepareStatement("INSERT INTO ENDUSER (ID, FNAME, LNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, eMail);
            preparedStatement.setString(5, password);

            preparedStatement.executeUpdate();
            addData(new EndUserImpl(id, fName, lName, eMail));
            result = true;

        } catch (SQLException e) {
            result = false;
        }

        return result;
    }

    public boolean deleteUser(EndUser endUser) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement;
        boolean result = false;

        connection = myconn.getConnection();
        preparedStatement = connection.prepareStatement("DELETE FROM ENDUSER WHERE ID = ?");
        preparedStatement.setInt(1, endUser.getId());

        if (preparedStatement.executeUpdate() == 1) {
            connection.commit();
            data.remove(endUser);
            result = true;
        } else {
            connection.rollback();
        }

        preparedStatement.close();

        return result;
    }

    public boolean checkLogin(String email, String password) throws SQLException {
        if (email.isEmpty() || password.isEmpty()) return false;

        Connection connection;
        PreparedStatement preparedStatement;

        connection = myconn.getConnection();
        preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM ENDUSER WHERE EMAIL = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) return false;

        int column = resultSet.findColumn("PASSWORD");
        String databasePW = resultSet.getString(column);

        preparedStatement.close();

        return password.equals(databasePW);
    }

    private int getNotUsedID(Connection connection) throws SQLException {
        int i = (int) (Math.random() * 1000000);
        return getNotUsedID(connection, i);
    }

    //Just for tests
    public int getNotUsedID(Connection connection, int i) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT ID FROM ENDUSER WHERE ID = ?");
        ps.setInt(1, i);
        ResultSet resultSet = ps.executeQuery();

        if (i == 0 || resultSet.next()) {
            return getNotUsedID(connection);
        }

        return i;
    }
}
