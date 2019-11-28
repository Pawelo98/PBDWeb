package app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Meetings")
public class Meeting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Building")
	private int buliding;
	
	@Column(name="Room")
	private String room;
	
	@Column(name="Initiator")
	private int initiator;
	
	@Column(name="Estimated_length")
	private float estimated_length;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Meeting_date")
	private Date meeting_date;
	
	
}
