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
// TODO Bad name
public interface Model {
	// TODO Do not use raw type
	List getData();

	// TODO Bad method for concept, throws SQLException
	boolean loadModel() throws SQLException;

	void addData(Object o);
}
