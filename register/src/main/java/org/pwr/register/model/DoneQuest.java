package org.pwr.register.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "done_quests", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id") })
public class DoneQuest implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@JoinColumn(name = "game")
	@ManyToOne(fetch = FetchType.EAGER)
	private UserGame userGame;
	
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

	public UserGame getUserGame() {
		return userGame;
	}

	public void setUserGame(UserGame userGame) {
		this.userGame = userGame;
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}

	
}
