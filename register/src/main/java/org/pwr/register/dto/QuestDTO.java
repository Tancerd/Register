package org.pwr.register.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.pwr.register.support.JsonDateSerializer;

@XmlRootElement
public class QuestDTO {

	private int defaultPoints;
	private Date defaultTime;
	private String name = "NAME"; //TODO

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDefaultPoints() {
		return defaultPoints;
	}
	public void setDefaultPoints(int defaultPoints) {
		this.defaultPoints = defaultPoints;
	}
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDefaultTime() {
		return defaultTime;
	}
	public void setDefaultTime(Date defaultTime) {
		this.defaultTime = defaultTime;
	}
	
}
