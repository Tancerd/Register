package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.DoneQuest;

public interface DoneQuestService {

	public List<DoneQuest> getAllDoneQuests();
	public DoneQuest getQuestById(int id);
	public boolean removeQuests(String userName);
	boolean createDoneQuest(DoneQuest doneQuest);
	
}
