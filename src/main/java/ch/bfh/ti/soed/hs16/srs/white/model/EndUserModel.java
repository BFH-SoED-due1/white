/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.model;

import ch.bfh.ti.soed.hs16.srs.white.concept.EndUser;
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
        myconn = DbConnection.getInstance();
        data = new ArrayList<EndUser>();
    }

    public List<EndUser> getEndUsers() {
        return (List<EndUser>) data;
    }

    @Override
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
                data.add(endUser);


            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return b;
    }

    @Override
    public void addData(Object o) {
        EndUser user = (EndUser) o;
        data.add(user);
    }

    public boolean saveUser(String fName, String lName, String eMail, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        int id;
        boolean result = false;

        try {
            connection = myconn.getConnection();
            id = getNotUsedID( connection );

            preparedStatement = connection.prepareStatement("INSERT INTO ENDUSER (ID, FNAME, LNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, eMail);
            preparedStatement.setString(5, password);

            if (preparedStatement.executeUpdate() == 1) {
                connection.commit();
                addData(new EndUserImpl(id, fName, lName, eMail));
                result = true;
            } else {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean deleteUser(EndUser endUser) {
        Connection connection;
        PreparedStatement preparedStatement;
        boolean result = false;

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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

    private int getNotUsedID(Connection connection) throws SQLException{
        int i = (int) (Math.random() * 1000000);
        PreparedStatement ps = connection.prepareStatement("SELECT ID FROM ENDUSER WHERE ID = ?");
        ps.setInt(1, i);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next() || i == 0) {
            return getNotUsedID(connection);
        }

        return i;
    }
}
