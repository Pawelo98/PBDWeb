package app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import app.entities.Referee.Nationality;

@Entity
@Table(name="Matches")
public class Match {
	
	public enum Winner { One ("1"), Two ("2"), Three ("3"); 
		
		private String name;
		
		Winner() {
	    }
	
	    Winner(String name) {
	        this.name = name;
	    }
	
	    public String getName() {
	        return this.name;
	    }    
    };

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="host_id")
	private Club host;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="visitor_id")
	private Club visitor;
	
	@Column(name="Home_goals")
	private int home_goals;
	
	@Column(name="Away_goals")
	private int away_goals;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Game_date")
	private Date game_date;
	
	@Column(name="Winner")
	@Enumerated(EnumType.STRING)
	private Winner winner;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
    				CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="id")
	private League league;

	public Match(int home_goals, int away_goals, Date game_date, String winner) {
		
		this.home_goals = home_goals;
		this.away_goals = away_goals;
		this.game_date = game_date;
		this.winner =Winner.valueOf(winner);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Club getHost() {
		return host;
	}

	public void setHost(Club host) {
		this.host = host;
	}

	public Club getVisitor() {
		return visitor;
	}

	public void setVisitor(Club visitor) {
		this.visitor = visitor;
	}

	public int getHome_goals() {
		return home_goals;
	}

	public void setHome_goals(int home_goals) {
		this.home_goals = home_goals;
	}

	public int getAway_goals() {
		return away_goals;
	}

	public void setAway_goals(int away_goals) {
		this.away_goals = away_goals;
	}

	public Date getGame_date() {
		return game_date;
	}

	public void setGame_date(Date game_date) {
		this.game_date = game_date;
	}

	public Winner getWinner() {
		return winner;
	}

	public void setWinner(Winner winner) {
		this.winner = winner;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", host=" + host + ", visitor=" + visitor + ", home_goals=" + home_goals
				+ ", away_goals=" + away_goals + ", game_date=" + game_date + ", winner=" + winner + ", league="
				+ league + "]";
	}
	

}
