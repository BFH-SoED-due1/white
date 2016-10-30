package ch.bfh.ti.soed.hs16.srs.white.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by joni on 20.10.2016.
 */
public class RoomTest {

	@Test
	public void testGettersAndSetters(){
		Room room = new Room();
		room.setName("abc");
		assertEquals("abc", room.getName());

		room.setQuantityOfSeats(42);
		assertEquals(42, room.getQuantityOfSeats());

		Reservation reservation = new Reservation();
		room.addReservation(reservation);
		// TODO: Following test fails since wrong:
		// assertEquals(reservation, room.getReservations());
		assertTrue(room.getReservations().contains(reservation));

	}

	@Test
	public void testAddReservation(){
		Room room = new Room();
		Reservation reservation = new Reservation();
		room.addReservation(reservation);
		assertTrue(room.getReservations().contains(reservation));
	}

	@Test
	public void testRemoveReservation(){
		Room room = new Room();
		Reservation reservationRemove = new Reservation();
		Reservation reservationRemain = new Reservation();
		room.addReservation(reservationRemove);
		room.addReservation(reservationRemain);
		room.removeReservation(reservationRemove);
		assertEquals(1, room.getReservations().size());
		assertFalse(room.getReservations().contains(reservationRemove));
	}





}