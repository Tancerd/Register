package org.pwr.register.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "user_game", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id") })

public class UserGame implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@JoinColumn(name = "user")
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	@Column(name = "end_time")
	private Date endTime;  // zmieniæ na Date
	@Column(name = "points")
	private Integer points;
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy="game")
	private Set<DoneQuest> doneQuests;
	*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	/*
	public Set<DoneQuest> getDoneQuests() {
		return doneQuests;
	}
	public void setDoneQuests(Set<DoneQuest> doneQuests) {
		this.doneQuests = doneQuests;
	}
	*/
}
