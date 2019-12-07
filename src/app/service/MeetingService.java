package app.service;

import java.util.List;

import app.entities.Meeting;

public interface MeetingService {

		public List<Meeting> getMeetings();

		public void saveMeeting(Meeting meeting);
	}

