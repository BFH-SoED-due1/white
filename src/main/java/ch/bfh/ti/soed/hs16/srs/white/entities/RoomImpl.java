/*
 * Copyright (c) 2017 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.white.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ch.bfh.ti.soed.hs16.srs.white.concept.Reservation;
import ch.bfh.ti.soed.hs16.srs.white.concept.Room;

/**
 * Created by arauzca on 19.10.16.
 */
// TODO Remove unnecessary annotation
@SuppressWarnings("unused")
public class RoomImpl implements Room {
	private String name;
	private int quantityOfSeats;
	private Set<Reservation> reservations = new HashSet<>();

	public RoomImpl(String name, int quantityOfSeats) {
		this.name = name;
		this.quantityOfSeats = quantityOfSeats;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getQuantityOfSeats() {
		return quantityOfSeats;
	}

	@Override
	public Set<Reservation> getReservations() {
		Set<Reservation> readOnlyReservations = Collections.unmodifiableSet(this.reservations);
		return readOnlyReservations;
	}

	@Override
	public void removeReservation(Reservation reservation) {
		reservations.remove(reservation);
	}

	@Override
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	@Override
	public void removeAllReservations() {
		reservations.clear();
	}

}
