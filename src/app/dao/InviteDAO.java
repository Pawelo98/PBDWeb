package app.dao;

import java.util.List;

import app.entities.Invite;

public interface InviteDAO {

	public List<Invite> getInvites();

	public void saveInvite(Invite invite);
}
