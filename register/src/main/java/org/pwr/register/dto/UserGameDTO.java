package org.pwr.register.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.pwr.register.support.JsonDateSerializer;


@XmlRootElement
@JsonAutoDetect
public class UserGameDTO implements Serializable{
	
	private String user;
	private int points;
	private List<DoneQuestDTO> setDoneQuestDTO;
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
	public List<DoneQuestDTO> getSetDoneQuestDTO() {
		return setDoneQuestDTO;
	}
	public void setSetDoneQuestDTO(List<DoneQuestDTO> setDoneQuestDTO) {
		this.setDoneQuestDTO = setDoneQuestDTO;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
	
	
}
