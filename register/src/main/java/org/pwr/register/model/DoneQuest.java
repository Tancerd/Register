package org.pwr.register.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "done_quest", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id") })
public class DoneQuest {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@JoinColumn(name = "game")
	@OneToOne(fetch = FetchType.EAGER)
	private Integer gameId;
	
	@JoinColumn(name = "quest")
	@OneToOne(fetch = FetchType.EAGER)
	private String questName;
	
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

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getQuestName() {
		return questName;
	}

	public void setQuest(String questName) {
		this.questName = questName;
	}
	
}
