package org.pwr.register.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.pwr.register.support.JsonDateSerializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@XmlRootElement
public class UserGameDTO implements Serializable{
	
	private String user;
	private int points;
	
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
	@JsonSerialize(using = JsonDateSerializer.class, include=JsonSerialize.Inclusion.ALWAYS)
	public Date getEndTime() {
		System.out.println("-----------------GET DATA");
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
}
