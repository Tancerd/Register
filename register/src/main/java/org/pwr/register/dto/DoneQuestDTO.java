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

	private UserGame game;
	private Quest quest;
	private Integer extraPoints;
	private Date doneTime;
	
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
