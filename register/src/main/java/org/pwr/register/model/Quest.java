package org.pwr.register.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Quest {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "default_time")
	private Date defaultTime;

	@Column(name = "default_points")
	private int defaultPoints;

	public Quest() {

	}

	public Quest(Date date, int points) {
		this.defaultTime = date;
		this.defaultPoints = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDefaultTime() {
		return defaultTime;
	}

	public void setDefaultTime(Date defaultTime) {
		this.defaultTime = defaultTime;
	}

	public int getDefaultPoints() {
		return defaultPoints;
	}

	public void setDefaultPoints(int defaultPoints) {
		this.defaultPoints = defaultPoints;
	}

}
