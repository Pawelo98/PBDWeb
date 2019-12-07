package app.service;

import java.util.List;

import app.entities.Invite;


public interface InviteService {
	
	public List<Invite> getInvites();

	public void saveInvite(Invite invite);

}
