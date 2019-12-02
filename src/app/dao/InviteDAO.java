package app.dao;

import java.util.List;

import app.entities.Invite;

public interface InviteDAO {

	public List<Invite> getCInvites();

	public void saveInvite(Invite invite);
}
