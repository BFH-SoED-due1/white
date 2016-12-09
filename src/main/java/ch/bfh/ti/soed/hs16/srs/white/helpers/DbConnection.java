/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by arauzca on 07.12.16.
 */
public abstract class DbConnection {
    private final static String protocol = "jdbc:derby:/Users/arauzca/Workspace/white/src/main/resources/ReservationSystem;user=sed_white;password=sedhs2016";
    private static Properties properties = new Properties();
    private static Connection connection;

    private static Connection getConnection() {
        try {
            //InputStream is = new FileInputStream(path);
            //properties.load(is);

            connection = DriverManager.getConnection(protocol);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            throw new NullPointerException();
        }

        return connection;
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }

        return connection;
    }

}
