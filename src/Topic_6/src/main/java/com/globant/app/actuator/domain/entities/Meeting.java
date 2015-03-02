package com.globant.app.actuator.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Identifiable{

	private String name;

	private List<Room> rooms;
	private List<Attendee> attendees;
	// TODO: Add time slot

	public Meeting() {
		this.rooms = new ArrayList<Room>();
		this.attendees = new ArrayList<Attendee>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

}
