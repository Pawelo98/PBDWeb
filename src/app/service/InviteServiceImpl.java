package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.InviteDAO;
import app.entities.Invite;

@Service
public class InviteServiceImpl implements InviteService {

	@Autowired
	private InviteDAO inviteDAO;
	
	@Override
	@Transactional
	public List<Invite> getInvites() {
		return inviteDAO.getInvites();
	}

	@Override
	@Transactional
	public void saveInvite(Invite invite) {
		inviteDAO.saveInvite(invite);
	}
}
