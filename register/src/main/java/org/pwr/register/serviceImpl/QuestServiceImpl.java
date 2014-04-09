package org.pwr.register.serviceImpl;

import java.util.List;

import org.pwr.register.dao.QuestDAO;
import org.pwr.register.model.Quest;
import org.pwr.register.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServiceImpl implements QuestService {

	@Autowired
	private QuestDAO questDAO;
	
	public List getAllQuests() {
		return questDAO.findAll();
	}

	public Quest getQuest(int id) {
		return questDAO.findQuestById(id);
	}

	public boolean deleteQuest(int id) {
		Quest q = getQuest(id);
		if (q != null)
			return questDAO.deleteQuest(q);
		else return true;
	}

	public boolean deleteAllQuests() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveQuest(Quest quest) {
		return questDAO.saveQuest(quest);
	}

	@Override
	public Quest getQuestByTitle(String name) {
		return questDAO.findQuestByTitle(name);
		
	}

}
