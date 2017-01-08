/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.concept.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by arauzca on 07.12.16.
 */
public interface Model {
    List getData();

    boolean loadModel() throws SQLException;
    void addData(Object o);
}
