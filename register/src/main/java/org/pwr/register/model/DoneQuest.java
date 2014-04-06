package org.pwr.register.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class DoneQuest {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@JoinColumn(name = "game")
	@OneToOne(fetch = FetchType.EAGER)
	private UserGame game;
	
	@JoinColumn(name = "quest")
	@OneToOne(fetch = FetchType.EAGER)
	private Quest quest;
	
	@Column(name = "extra_points", nullable = true, unique = false)
	private Integer extraPoints;
	
	@Column(name = "done_time")
	private Date doneTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserGame getGame() {
		return game;
	}

	public void setGame(UserGame game) {
		this.game = game;
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	public Integer getExtraPoints() {
		return extraPoints;
	}

	public void setExtraPoints(Integer extraPoints) {
		this.extraPoints = extraPoints;
	}

	public Date getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(Date doneTime) {
		this.doneTime = doneTime;
	}
	
}
