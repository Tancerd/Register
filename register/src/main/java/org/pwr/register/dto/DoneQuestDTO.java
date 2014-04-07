package org.pwr.register.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.pwr.register.model.Quest;
import org.pwr.register.model.UserGame;

@XmlRootElement
public class DoneQuestDTO {

	private Integer gameId;
	private String questName;
	private Integer extraPoints;
	private Date doneTime;
	
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	
	public String getQuestName() {
		return questName;
	}
	public void setQuestName(String questName) {
		this.questName = questName;
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
