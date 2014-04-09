package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.DoneQuest;

public interface DoneQuestService {

	public List<DoneQuest> getAllQuests();
	public DoneQuest getQuestById(int id);
	public boolean removeQuest(String userName);
	boolean createDoneQuest(DoneQuest doneQuest);
	
}
