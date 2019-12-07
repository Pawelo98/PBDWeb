package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.MeetingDAO;
import app.entities.Meeting;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingDAO meetingDAO;
	
	@Override
	@Transactional
	public List<Meeting> getMeetings() {
		return meetingDAO.getMeetings();
	}

	@Override
	@Transactional
	public void saveMeeting(Meeting meeting) {
		meetingDAO.saveMeeting(meeting);
	}
}
