package app.dao;

import java.util.List;

import app.entities.Meeting;

public interface MeetingDAO {

	public List<Meeting> getMeetings();

	public void saveMeeting(Meeting meeting);
}
