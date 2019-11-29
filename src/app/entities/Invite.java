package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Invites")
public class Invite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int invite_id;
	
	@Column(name="Message")
	private String message;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="meeting_id")
	private Meeting meeting;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="worker_id")
	private Worker worker;
	
	
	public Invite(String message) {
		
		this.message = message;
		
	}

	public int getInvite_id() {
		return invite_id;
	}

	public void setInvite_id(int invite_id) {
		this.invite_id = invite_id;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	@Override
	public String toString() {
		return "Invite [invite_id=" + invite_id + ", message=" + message + ", meeting=" + meeting + ", worker=" + worker
				+ "]";
	}

	
	
	
}
