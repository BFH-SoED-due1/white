/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by arauzca on 07.12.16.
 */
public abstract class DbConnection {
    private static Properties properties = new Properties();

    public static Connection getConnection() {
        Connection connection = null;

        try {
            StringBuilder protocolBuilder   = new StringBuilder("jdbc:derby:");
            ResourcesHelper resourcesHelper = ResourcesHelper.getInstance();
            String path                     = resourcesHelper.getPath();

            protocolBuilder.append(path).append("ReservationSystem");

            InputStream propertiesFile      = new FileInputStream(path + "db.properties");
            properties.load(propertiesFile);
            propertiesFile.close();

            String protocol = protocolBuilder.toString();
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            connection = DriverManager.getConnection(protocol, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

}
