package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.Quest;

public interface QuestService {

	public List getAllQuests();
	public Quest getQuest(int id);
	public boolean deleteQuest(int id);
	public boolean deleteAllQuests();
	public boolean saveQuest(Quest quest);
}
