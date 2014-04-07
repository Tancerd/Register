package org.pwr.register.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.support.JsonDateSerializer;


@XmlRootElement
@JsonAutoDetect
public class UserGameDTO implements Serializable{
	
	private String user;
	private int points;
	private Set<DoneQuest> listDoneQuest;
	private Date endTime;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setDoneQuests(Set<DoneQuest> doneQuests) {
		this.listDoneQuest = doneQuests;
	}
	
	
}
