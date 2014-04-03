package org.pwr.register.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuestDTO {

	private int defaultPoints;
	private Date defaultTime;

	
	public int getDefaultPoints() {
		return defaultPoints;
	}
	public void setDefaultPoints(int defaultPoints) {
		this.defaultPoints = defaultPoints;
	}
	public Date getDefaultTime() {
		return defaultTime;
	}
	public void setDefaultTime(Date defaultTime) {
		this.defaultTime = defaultTime;
	}
	
}
