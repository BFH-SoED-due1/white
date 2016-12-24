/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.implementations;

import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hyamsj on 20.10.2016.
 */
public class RoomTest {

	@Test
	public void testGettersAndSetters(){
		Room room = new RoomImpl(1,"abc", 42);
		assertEquals("abc", room.getName());
		assertEquals(42, room.getQuantityOfSeats());

		Reservation reservation = new ReservationImpl();
		room.addReservation(reservation);
		// TODO: Following test fails since wrong:
		// assertEquals(reservation, room.getReservations());
		assertTrue(room.getReservations().contains(reservation));

	}

	@Test
	public void testAddReservation(){
		Room room = new RoomImpl(1,"", 0);
		Reservation reservation = new ReservationImpl();
		room.addReservation(reservation);
		assertTrue(room.getReservations().contains(reservation));
	}

	@Test
	public void testRemoveReservation(){
		Room room = new RoomImpl(1,"", 0);
		ReservationImpl reservationRemove = new ReservationImpl();
		ReservationImpl reservationRemain = new ReservationImpl();
		room.addReservation(reservationRemove);
		room.addReservation(reservationRemain);
		room.removeReservation(reservationRemove);
		assertEquals(1, room.getReservations().size());
		assertFalse(room.getReservations().contains(reservationRemove));
	}





}